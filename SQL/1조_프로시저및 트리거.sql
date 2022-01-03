--● 프로시저 


--○ 동아리 입력(개설) 프로시저
CREATE OR REPLACE PROCEDURE PRC_CLUB_INSERT
(
    V_TITLE            IN CLUB.TITLE%TYPE
    ,V_ID              IN MEMBERINFO.ID%TYPE
    ,V_MAX             IN CLUB.MAX%TYPE
    ,V_CONTENT         IN CLUB.CONTENT%TYPE
    ,V_CATEGORY_S_ID   IN CLUB.CATEGORY_S_ID%TYPE
    ,V_REGION_S_ID     IN CLUB.REGION_S_ID%TYPE
    ,V_URL             IN CLUB.URL%TYPE
    ,V_LIMIT_ID        IN CLUB.LIMIT_ID%TYPE
    ,V_AGELIMIT_ID     IN CLUB.AGELIMIT_ID%TYPE
)
IS
    SEQ          NUMBER;
    V_MID        CLUB.MID%TYPE;
    USER_DEFINE_ERROR   EXCEPTION;
BEGIN
    
    --받은 id로 MID SELECT
    SELECT MID INTO V_MID
    FROM MEMBERINFO
    WHERE ID=V_ID;

    SELECT NVL(MAX(TO_NUMBER(SUBSTR(CID,2))),0) +1 INTO SEQ
    FROM CLUB;
    
    -- 동아리 INSERT  
    INSERT INTO CLUB(CID,TITLE,MID,PREOPENDATE,BDATE,MAX,CONTENT,CATEGORY_S_ID,REGION_S_ID,URL,LIMIT_ID,AGELIMIT_ID)
    VALUES ('C'||SEQ,V_TITLE,V_MID,SYSDATE,NULL,V_MAX,V_CONTENT,V_CATEGORY_S_ID,V_REGION_S_ID,V_URL,V_LIMIT_ID,V_AGELIMIT_ID);
    
    -- 가입신청 INSERT
    INSERT INTO JOIN_CLUB(JOIN_ID, CID, MID, BDATE) 
    VALUES('JC'||JOIN_CLUBSEQ.NEXTVAL,'C'||SEQ ,V_MID,SYSDATE); 
    
    SELECT NVL(MAX(TO_NUMBER(SUBSTR(JOIN_ID,3))),0) INTO SEQ
    FROM JOIN_CLUB;
    
    -- 동아리회원목록 INSERT 
    INSERT INTO CLUBMEMBERLIST(CLUBMEM_ID,JOIN_ID,BDATE,POSITION_ID) 
    VALUES ('CM'||CLUBMEMBERLISTSEQ.NEXTVAL, 'JC'||SEQ , SYSDATE, '4');
    
    COMMIT; 
    
    EXCEPTION
        WHEN USER_DEFINE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20003, '활동동아리 갯수 제한으로 인한 동아리 개설 불가!');
            ROLLBACK;
            
END;

--○ 동아리 삭제 트리거

-- 가입신청자 삭제 
CREATE OR REPLACE TRIGGER CLUB_DELETE
        BEFORE 
        DELETE ON CLUB
        FOR EACH ROW
BEGIN    
    DELETE
    FROM JOIN_CLUB
    WHERE CID=:OLD.CID;
END;

--○ 지원한 스태프, 총무 선정 프로시저
-- cid와 mid를 받아서 해당 가입신청 코드에 해당하는 정보를 가지고
-- 동아리 회원목록에 insert 하는 프로시저 
CREATE OR REPLACE PROCEDURE PRC_CLUBMEM_INSERT
(
    V_CID              IN CLUB.CID%TYPE
    ,V_MID              IN MEMBERINFO.MID%TYPE
   
)
IS
    V_JOIN_ID       JOIN_CLUB.JOIN_ID%TYPE;
    V_POSITION_ID   JOIN_CLUB.POSITION_ID%TYPE;
    USER_DEFINE_ERROR  EXCEPTION;
BEGIN
    
    --받은 CID와 MID를 통해 가입신청 코드 조회
    SELECT JOIN_ID,POSITION_ID INTO V_JOIN_ID,V_POSITION_ID
    FROM JOIN_CLUB
    WHERE CID = V_CID AND MID = V_MID;
    
    -- 동아리회원목록 INSERT 
    INSERT INTO CLUBMEMBERLIST(CLUBMEM_ID,JOIN_ID,BDATE,POSITION_ID) 
    VALUES ('CM'||CLUBMEMBERLISTSEQ.NEXTVAL, V_JOIN_ID , SYSDATE, V_POSITION_ID);
    
    COMMIT; 
    
    EXCEPTION
        WHEN USER_DEFINE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20010, '회원목록 추가 에러');
            ROLLBACK;
            
END;

--○ 추가 지역 프로시저 
CREATE OR REPLACE PROCEDURE PRC_ADD_REGION_INSERT
(
  V_ID             IN ADD_REGION.ID%TYPE
, V_REGION_S_ID    IN ADD_REGION.REGION_S_ID%TYPE
)
IS 
    V_ADD_REGION_ID   ADD_REGION.ADD_REGION_ID%TYPE;
    IDCOUNT           NUMBER;
    USER_DEFINE_ERROR   EXCEPTION;
    
BEGIN

    SELECT NVL(MAX(ADD_REGION_ID),0) +1 INTO V_ADD_REGION_ID
    FROM ADD_REGION;
    
    SELECT COUNT(*) INTO IDCOUNT  
    FROM ADD_REGION
    WHERE ID = V_ID;
    
    
    IF(IDCOUNT >= 2)
        THEN RAISE USER_DEFINE_ERROR;
    END IF;
    
    --입력
    INSERT INTO ADD_REGION(ADD_REGION_ID, ID, REGION_S_ID) 
    VALUES (V_ADD_REGION_ID,V_ID,V_REGION_S_ID);
    
    --COMMIT;
    
    EXCEPTION
        WHEN USER_DEFINE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20001, '지역 추가는 2개까지 가능합니다!');
            ROLLBACK;
    
END;

-- 실험
EXEC PRC_ADD_REGION_INSERT('MI1', '4');
EXEC PRC_ADD_REGION_INSERT('MI2', '4');


--○ 추가 카테고리 프로시저 
CREATE OR REPLACE PROCEDURE PRC_ADD_CATEGORY_INSERT
(
  V_MID             IN ADD_CATEGORY.MID%TYPE
, V_CATEGORY_S_ID     IN ADD_CATEGORY.CATEGORY_S_ID%TYPE
)
IS 
    V_ADD_CATEGORY_ID   ADD_CATEGORY.ADD_CATEGORY_ID%TYPE;
    MIDCOUNT            NUMBER;
    USER_DEFINE_ERROR   EXCEPTION;
    
BEGIN

    SELECT NVL(MAX(ADD_CATEGORY_ID),0) +1 INTO V_ADD_CATEGORY_ID
    FROM ADD_CATEGORY;
    
    SELECT COUNT(*) INTO MIDCOUNT  
    FROM ADD_CATEGORY
    WHERE MID = V_MID;
    
    IF(MIDCOUNT >= 4)
        THEN RAISE USER_DEFINE_ERROR;
    END IF;
    
    --입력
    INSERT INTO ADD_CATEGORY(ADD_CATEGORY_ID, MID, CATEGORY_S_ID) 
    VALUES (V_ADD_CATEGORY_ID,V_MID,V_CATEGORY_S_ID);
    
    --COMMIT;
    
    EXCEPTION
        WHEN USER_DEFINE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20002, '카테고리 추가는 4개까지 가능합니다!');
            ROLLBACK;
    
END;

-- 모임 개설 인서트 프로시저
CREATE OR REPLACE PROCEDURE BEE_BEE_REQ_INSERT
( V_TYPE_ID         IN BEE.TYPE_ID%TYPE
, V_TITLE           IN BEE.TITLE%TYPE
, V_CLUBMEM_ID      IN BEE.CLUBMEM_ID%TYPE
, V_CONTENT         IN BEE.CONTENT%TYPE
, V_BEE_TIME        IN BEE.BEE_TIME%TYPE
, V_LOCATION        IN BEE.LOCATION%TYPE
, V_MIN             IN BEE.MIN%TYPE
, V_MAX             IN BEE.MAX%TYPE
, V_FEE             IN BEE.FEE%TYPE
)
IS
    V_BEE_ID        BEE.BEE_ID%TYPE;
BEGIN

    -- 수행되어야 하는 쿼리문 구성
    -- 1. INSERT → BEE
    INSERT INTO BEE(BEE_ID, TYPE_ID, TITLE, CLUBMEM_ID, CONTENT, BEE_TIME, WEATHER, LOCATION, MIN, MAX, FEE, BDATE)
    VALUES(BEESEQ.NEXTVAL, V_TYPE_ID, V_TITLE, V_CLUBMEM_ID, V_CONTENT, V_BEE_TIME, NULL, V_LOCATION, V_MIN, V_MAX, V_FEE, SYSDATE);
    
    -- 선언한 변수에 값 담아내기
    SELECT MAX(TO_NUMBER(BEE_ID)) INTO V_BEE_ID
    FROM BEE;
    
    -- 2. INSERT → BEE_REQ
    INSERT INTO BEE_REQ(REQ_ID, CLUBMEM_ID, BEE_ID, BDATE) 
    VALUES(BEE_REQSEQ.NEXTVAL, V_CLUBMEM_ID, V_BEE_ID, SYSDATE);
    
    -- 커밋
    COMMIT;
    
    -- 예외 처리
    EXCEPTION
        WHEN OTHERS THEN ROLLBACK;
END;
--==>> Procedure BEE_BEE_REQ_INSERT이(가) 컴파일되었습니다.

-- 회원가입 프로시저
CREATE OR REPLACE PROCEDURE JOIN_INSERT
( V_CATEGORY_S_ID_1     IN MEMBER.CATEGORY_S_ID%TYPE    -- MEMBER
, V_NAME                IN MEMBERINFO.NAME%TYPE         -- MEMBERINFO
, V_SSN                 IN MEMBERINFO.SSN%TYPE
, V_EMAIL               IN MEMBERINFO.EMAIL%TYPE
, V_TEL                 IN MEMBERINFO.TEL%TYPE
, V_PWD                 IN MEMBERINFO.PWD%TYPE
, V_NICKNAME            IN MEMBERINFO.NICKNAME%TYPE
, V_URL                 IN MEMBERINFO.URL%TYPE
, V_REGION_S_ID_1       IN MEMBERINFO.REGION_S_ID%TYPE
, V_USERID              IN MEMBERINFO.USERID%TYPE
)
IS
    V_MID           MEMBER.MID%TYPE;
BEGIN

    -- 선언한 변수에 값 담아내기(1번에서 MEMBER 테이블에 INSERT한 값의 MID를 불러오기 위함)
    SELECT MEMBERSEQ.NEXTVAL INTO V_MID
    FROM DUAL;
    
    -- 수행되어야 하는 쿼리문 구성
    -- 1. INSERT → MEMBER
    INSERT INTO MEMBER(MID, BDATE, LOGIN_DATE, CATEGORY_S_ID)
    VALUES('M'|| V_MID, SYSDATE, SYSDATE, V_CATEGORY_S_ID_1);
    
    -- 2. INSERT → MEMBERINFO
    INSERT INTO MEMBERINFO(ID, NAME, SSN, EMAIL, TEL, PWD, NICKNAME, URL, REGION_S_ID, MID, USERID) 
    VALUES('MI'|| MEMBERINFOSEQ.NEXTVAL, V_NAME, V_SSN, V_EMAIL, V_TEL
    , V_PWD, V_NICKNAME, V_URL, V_REGION_S_ID_1, 'M'||V_MID, V_USERID);
    
    -- 커밋
    COMMIT;
    
    -- 예외 처리
    EXCEPTION
        WHEN OTHERS THEN ROLLBACK;
END;
--==>> Procedure JOIN_INSERT이(가) 컴파일되었습니다.

--------------------------------------------------------------------------------
--○ 트리거

-- 신청자 있는 경우 모임 삭제 트리거
CREATE OR REPLACE TRIGGER BEE_DELETE
        BEFORE 
        DELETE ON BEE
        FOR EACH ROW
BEGIN    
    DELETE
    FROM BEE_REQ
    WHERE BEE_ID=:OLD.BEE_ID;
END;
--==>> Trigger BEE_DELETE이(가) 컴파일되었습니다.


-- 신청자 있는 경우
CREATE OR REPLACE TRIGGER BEE_REQ_DELETE
        BEFORE 
        DELETE ON BEE_REQ
        FOR EACH ROW
BEGIN
    DELETE
    FROM ABSENT
    WHERE REQ_ID=:OLD.REQ_ID;
END;
--==>> Trigger BEE_REQ_DELETE이(가) 컴파일되었습니다.






--------------------------------------------------------------------------------
--● 데이터 생성 프로시저

--○ 자유게시판 게시글 생성
DECLARE  
	V_MID	    VARCHAR2(20);
    V_NICKNAME  VARCHAR2(50);
	V_TITLE	    VARCHAR2(100);
	V_CONTENT   VARCHAR2(4000);
    V_BDATE      DATE             := TO_DATE('2015-12-02', 'YYYY-MM-DD');
    V_NUM       NUMBER :=1 ;
BEGIN
    LOOP
        EXIT WHEN V_NUM > 51;
        
        V_NUM := V_NUM + 1;
        
        IF (MOD(V_NUM, 5)=0) THEN
            V_MID := 'M1';
        ELSIF (MOD(V_NUM, 3)=0) THEN
            V_MID := 'M2';
        ELSIF (MOD(V_NUM, 7)=0) THEN
            V_MID := 'M3';
        ELSIF (MOD(V_NUM, 9)=0) THEN
            V_MID := 'M7';   
        ELSIF (MOD(V_NUM, 11)=0) THEN
            V_MID := 'M9';
        ELSIF (MOD(V_NUM, 17)=0) THEN
            V_MID := 'M8';   
        ELSIF (MOD(V_NUM, 23)=0) THEN
            V_MID := 'M5';
        ELSE
            V_MID := 'M4';
        END IF;
        
        SELECT F.NICKNAME INTO V_NICKNAME
        FROM MEMBER M, MEMBERINFO F
        WHERE M.MID = V_MID AND M.MID=F.MID;
        
        IF (MOD(V_NUM, 10)=0) THEN
             V_BDATE := V_BDATE + 1;
        END IF;
        
        
        IF (MOD(V_NUM, 6)=0) THEN
            V_TITLE := V_NICKNAME || ' 추천 취미!';
        ELSIF (MOD(V_NUM, 3)=0) THEN
            V_TITLE := '안녕하세요. ' || V_NICKNAME || '입니다~~';
        ELSIF (MOD(V_NUM, 5)=0) THEN
            V_TITLE := V_NICKNAME || '이(가) 작성한 게시물입니다.';
        ELSIF (MOD(V_NUM, 9)=0) THEN
            V_TITLE := V_NICKNAME || ', 이 닉네임 어떤가요?';
        ELSIF (MOD(V_NUM, 7)=0) THEN
            V_TITLE := '같은 동네에 사시는 분 찾아요! 저는' || V_NICKNAME || '입니다!';
        ELSIF (MOD(V_NUM, 4)=0) THEN
            V_TITLE := '동아리 꿀팁 ' || V_NICKNAME || '이(가) 알려드릴까요?';
        ELSE
            V_TITLE := '게시판 이렇게 쓰는 거 맞죠?';
        END IF;
        
        V_CONTENT := V_TITLE || ' 제목은 이겁니다! 내용은 나중에 추가할게요!!!!';
        
        -- 날짜 SYSDATE로 설정함, 조회수도 디폴트로
        INSERT INTO FREE_B(B_ID, MID, TITLE, CONTENT, BDATE)
        VALUES(FREE_BSEQ.NEXTVAL, V_MID, V_TITLE, V_CONTENT, V_BDATE);
    END LOOP;
END;
--==>> PL/SQL 프로시저가 성공적으로 완료되었습니다.




--○ 카테고리별 게시판
DECLARE  
	V_MID	        VARCHAR2(20);
    V_CATEGORY_S_ID VARCHAR2(20);
	V_TITLE	        VARCHAR2(100);
	V_CONTENT       VARCHAR2(4000);
    V_BDATE         DATE             := TO_DATE('2015-12-05', 'YYYY-MM-DD');
    V_NUM           NUMBER :=1 ;
    V_S_CAT         VARCHAR(50);
BEGIN
    LOOP
        EXIT WHEN V_NUM > 51;
        
        V_NUM := V_NUM + 1;
        
        IF (MOD(V_NUM, 5)=0) THEN
            V_MID := 'M1';
        ELSIF (MOD(V_NUM, 3)=0) THEN
            V_MID := 'M2';
        ELSIF (MOD(V_NUM, 7)=0) THEN
            V_MID := 'M3';
        ELSIF (MOD(V_NUM, 9)=0) THEN
            V_MID := 'M7';   
        ELSIF (MOD(V_NUM, 11)=0) THEN
            V_MID := 'M9';
        ELSIF (MOD(V_NUM, 17)=0) THEN
            V_MID := 'M8';   
        ELSIF (MOD(V_NUM, 23)=0) THEN
            V_MID := 'M5';
        ELSE
            V_MID := 'M4';
        END IF;
        
        
        IF (MOD(V_NUM, 7)=0) THEN
            V_CATEGORY_S_ID := '1';
        ELSIF (MOD(V_NUM, 11)=0) THEN
            V_CATEGORY_S_ID := '2';
        ELSIF (MOD(V_NUM, 5)=0) THEN
            V_CATEGORY_S_ID := '3';
        ELSIF (MOD(V_NUM, 9)=0) THEN
            V_CATEGORY_S_ID := '4';   
        ELSIF (MOD(V_NUM, 3)=0) THEN
            V_CATEGORY_S_ID := '5';
        ELSIF (MOD(V_NUM, 6)=0) THEN
            V_CATEGORY_S_ID := '6';   
        ELSIF (MOD(V_NUM, 23)=0) THEN
            V_CATEGORY_S_ID := '7';
        ELSE
            V_CATEGORY_S_ID := '8';
        END IF;
        
        V_BDATE := V_BDATE + 1;
        
        SELECT S_CAT INTO V_S_CAT
        FROM CATEGORY_S
        WHERE CATEGORY_S_ID = V_CATEGORY_S_ID;
        
        
        IF (MOD(V_NUM, 6)=0) THEN
            V_TITLE := V_S_CAT || ' 어때요?';
        ELSIF (MOD(V_NUM, 3)=0) THEN
            V_TITLE := '안녕하세요. ' || V_S_CAT || ' 같이 해요!';
        ELSIF (MOD(V_NUM, 5)=0) THEN
            V_TITLE := V_S_CAT || ' 하기에 더 좋은 곳 있어요???';
        ELSIF (MOD(V_NUM, 9)=0) THEN
            V_TITLE := V_S_CAT || '... 더 잘 하고 싶어요...';
        ELSIF (MOD(V_NUM, 7)=0) THEN
            V_TITLE := '같은 취미 가진 분 찾아요! ' || V_S_CAT || ' 같이 해요!';
        ELSIF (MOD(V_NUM, 11)=0) THEN
            V_TITLE := '돈 쉽게 버는 방법 알려드립니다!!!!';
        ELSE
            V_TITLE := '카테고리별 게시판 이렇게 쓰는 거 맞죠?';
        END IF;
        
        V_CONTENT := V_TITLE || ' 제목은 이겁니다! 내용은 나중에 추가할게요!!!!';
        
        -- 날짜 SYSDATE로 설정함, 조회수도 디폴트로
        INSERT INTO CATEGORY_B(B_ID, CATEGORY_S_ID, MID, TITLE, CONTENT, BDATE)
        VALUES(CATEGORY_BSEQ.NEXTVAL, V_CATEGORY_S_ID, V_MID, V_TITLE, V_CONTENT, V_BDATE);
    END LOOP;
END;
--==>> PL/SQL 프로시저가 성공적으로 완료되었습니다.




--○ 정모 데이터 생성
DECLARE 
	V_TITLE	        VARCHAR2(100);
	V_CONTENT       VARCHAR2(4000);
    V_BEE_TIME      DATE                := TO_DATE('2019-12-05 18:00:00', 'YYYY-MM-DD HH24:MI:SS');
    V_BDATE         DATE                := TO_DATE('2019-11-05', 'YYYY-MM-DD');
    V_NUM           NUMBER :=0 ;
    V_FEE           NUMBER :=0 ;
BEGIN
    LOOP
        EXIT WHEN V_NUM > 23;
        
        V_NUM := V_NUM + 1;
        
        
        IF (MOD(V_NUM, 3)=0) THEN
            V_FEE := 30000;
        ELSIF (MOD(V_NUM, 4)=0) THEN
            V_FEE := 50000;
        ELSIF (MOD(V_NUM, 5)=0) THEN
            V_FEE := 70000;
        ELSIF (MOD(V_NUM, 2)=0) THEN
            V_FEE := 35000;  
        ELSE
            V_FEE := 55000;
        END IF;
        
        V_BEE_TIME := ADD_MONTHS(V_BEE_TIME, 1); -- 모임날짜
        V_BDATE := ADD_MONTHS(V_BDATE, 1); -- 작성일
        
        
        V_TITLE := TO_CHAR(V_NUM) || '회차 정기모임입니다!';
        
        V_CONTENT := TO_CHAR(V_NUM) || '번째 만남이네요. 정기모임 꼭 참석해주세요!';
        
        -- 우선 날씨 NULL, 위치 '0'으로 넣었음. 최소인원 3명, 최대인원은 NULL
        INSERT INTO BEE(BEE_ID, TYPE_ID, TITLE, CLUBMEM_ID, CONTENT, BEE_TIME, WEATHER, LOCATION, MIN, MAX, FEE, BDATE)
        VALUES(BEESEQ.NEXTVAL, '1', V_TITLE, 'CM1', V_CONTENT, V_BEE_TIME, NULL, '0', 3, NULL, V_FEE, V_BDATE);
    END LOOP;
END;
--==>> PL/SQL 프로시저가 성공적으로 완료되었습니다.



--○ 정모 참석자 데이터 생성(동아리장)
DECLARE 
	V_CLUBMEM_ID	VARCHAR2(100);
    V_BDATE         DATE;
    
    V_NUM           NUMBER :=0 ;
BEGIN
    LOOP
        EXIT WHEN V_NUM > 23;
        
        V_NUM := V_NUM + 1;
        
        SELECT BDATE INTO V_BDATE
        FROM BEE
        WHERE BEE_ID = V_NUM;
        
        
        -- 우선 날씨 NULL, 위치 '0'으로 넣었음. 최소인원 3명, 최대인원은 NULL
        INSERT INTO BEE_REQ(REQ_ID, CLUBMEM_ID, BEE_ID, BDATE)
        VALUES(BEE_REQSEQ.NEXTVAL, 'CM1', V_NUM, V_BDATE + 2);
    END LOOP;
END;



--○ 정모 참석자 데이터 생성(동아리원)
DECLARE 
	V_CLUBMEM_ID	VARCHAR2(100);
    V_BDATE         DATE;
    
    V_NUM           NUMBER :=-1 ;
BEGIN
    LOOP
        EXIT WHEN V_NUM > 8;
        
        V_NUM := V_NUM + 2;
        
        SELECT BDATE INTO V_BDATE
        FROM BEE
        WHERE BEE_ID = V_NUM;
        
        
        -- 우선 날씨 NULL, 위치 '0'으로 넣었음. 최소인원 3명, 최대인원은 NULL
        INSERT INTO BEE_REQ(REQ_ID, CLUBMEM_ID, BEE_ID, BDATE)
        VALUES(BEE_REQSEQ.NEXTVAL, 'CM14', V_NUM, V_BDATE + 3);
    END LOOP;
END;




