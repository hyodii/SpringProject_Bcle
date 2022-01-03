--�� ���ν��� 


--�� ���Ƹ� �Է�(����) ���ν���
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
    
    --���� id�� MID SELECT
    SELECT MID INTO V_MID
    FROM MEMBERINFO
    WHERE ID=V_ID;

    SELECT NVL(MAX(TO_NUMBER(SUBSTR(CID,2))),0) +1 INTO SEQ
    FROM CLUB;
    
    -- ���Ƹ� INSERT  
    INSERT INTO CLUB(CID,TITLE,MID,PREOPENDATE,BDATE,MAX,CONTENT,CATEGORY_S_ID,REGION_S_ID,URL,LIMIT_ID,AGELIMIT_ID)
    VALUES ('C'||SEQ,V_TITLE,V_MID,SYSDATE,NULL,V_MAX,V_CONTENT,V_CATEGORY_S_ID,V_REGION_S_ID,V_URL,V_LIMIT_ID,V_AGELIMIT_ID);
    
    -- ���Խ�û INSERT
    INSERT INTO JOIN_CLUB(JOIN_ID, CID, MID, BDATE) 
    VALUES('JC'||JOIN_CLUBSEQ.NEXTVAL,'C'||SEQ ,V_MID,SYSDATE); 
    
    SELECT NVL(MAX(TO_NUMBER(SUBSTR(JOIN_ID,3))),0) INTO SEQ
    FROM JOIN_CLUB;
    
    -- ���Ƹ�ȸ����� INSERT 
    INSERT INTO CLUBMEMBERLIST(CLUBMEM_ID,JOIN_ID,BDATE,POSITION_ID) 
    VALUES ('CM'||CLUBMEMBERLISTSEQ.NEXTVAL, 'JC'||SEQ , SYSDATE, '4');
    
    COMMIT; 
    
    EXCEPTION
        WHEN USER_DEFINE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20003, 'Ȱ�����Ƹ� ���� �������� ���� ���Ƹ� ���� �Ұ�!');
            ROLLBACK;
            
END;

--�� ���Ƹ� ���� Ʈ����

-- ���Խ�û�� ���� 
CREATE OR REPLACE TRIGGER CLUB_DELETE
        BEFORE 
        DELETE ON CLUB
        FOR EACH ROW
BEGIN    
    DELETE
    FROM JOIN_CLUB
    WHERE CID=:OLD.CID;
END;

--�� ������ ������, �ѹ� ���� ���ν���
-- cid�� mid�� �޾Ƽ� �ش� ���Խ�û �ڵ忡 �ش��ϴ� ������ ������
-- ���Ƹ� ȸ����Ͽ� insert �ϴ� ���ν��� 
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
    
    --���� CID�� MID�� ���� ���Խ�û �ڵ� ��ȸ
    SELECT JOIN_ID,POSITION_ID INTO V_JOIN_ID,V_POSITION_ID
    FROM JOIN_CLUB
    WHERE CID = V_CID AND MID = V_MID;
    
    -- ���Ƹ�ȸ����� INSERT 
    INSERT INTO CLUBMEMBERLIST(CLUBMEM_ID,JOIN_ID,BDATE,POSITION_ID) 
    VALUES ('CM'||CLUBMEMBERLISTSEQ.NEXTVAL, V_JOIN_ID , SYSDATE, V_POSITION_ID);
    
    COMMIT; 
    
    EXCEPTION
        WHEN USER_DEFINE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20010, 'ȸ����� �߰� ����');
            ROLLBACK;
            
END;

--�� �߰� ���� ���ν��� 
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
    
    --�Է�
    INSERT INTO ADD_REGION(ADD_REGION_ID, ID, REGION_S_ID) 
    VALUES (V_ADD_REGION_ID,V_ID,V_REGION_S_ID);
    
    --COMMIT;
    
    EXCEPTION
        WHEN USER_DEFINE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20001, '���� �߰��� 2������ �����մϴ�!');
            ROLLBACK;
    
END;

-- ����
EXEC PRC_ADD_REGION_INSERT('MI1', '4');
EXEC PRC_ADD_REGION_INSERT('MI2', '4');


--�� �߰� ī�װ� ���ν��� 
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
    
    --�Է�
    INSERT INTO ADD_CATEGORY(ADD_CATEGORY_ID, MID, CATEGORY_S_ID) 
    VALUES (V_ADD_CATEGORY_ID,V_MID,V_CATEGORY_S_ID);
    
    --COMMIT;
    
    EXCEPTION
        WHEN USER_DEFINE_ERROR
            THEN RAISE_APPLICATION_ERROR(-20002, 'ī�װ� �߰��� 4������ �����մϴ�!');
            ROLLBACK;
    
END;

-- ���� ���� �μ�Ʈ ���ν���
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

    -- ����Ǿ�� �ϴ� ������ ����
    -- 1. INSERT �� BEE
    INSERT INTO BEE(BEE_ID, TYPE_ID, TITLE, CLUBMEM_ID, CONTENT, BEE_TIME, WEATHER, LOCATION, MIN, MAX, FEE, BDATE)
    VALUES(BEESEQ.NEXTVAL, V_TYPE_ID, V_TITLE, V_CLUBMEM_ID, V_CONTENT, V_BEE_TIME, NULL, V_LOCATION, V_MIN, V_MAX, V_FEE, SYSDATE);
    
    -- ������ ������ �� ��Ƴ���
    SELECT MAX(TO_NUMBER(BEE_ID)) INTO V_BEE_ID
    FROM BEE;
    
    -- 2. INSERT �� BEE_REQ
    INSERT INTO BEE_REQ(REQ_ID, CLUBMEM_ID, BEE_ID, BDATE) 
    VALUES(BEE_REQSEQ.NEXTVAL, V_CLUBMEM_ID, V_BEE_ID, SYSDATE);
    
    -- Ŀ��
    COMMIT;
    
    -- ���� ó��
    EXCEPTION
        WHEN OTHERS THEN ROLLBACK;
END;
--==>> Procedure BEE_BEE_REQ_INSERT��(��) �����ϵǾ����ϴ�.

-- ȸ������ ���ν���
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

    -- ������ ������ �� ��Ƴ���(1������ MEMBER ���̺� INSERT�� ���� MID�� �ҷ����� ����)
    SELECT MEMBERSEQ.NEXTVAL INTO V_MID
    FROM DUAL;
    
    -- ����Ǿ�� �ϴ� ������ ����
    -- 1. INSERT �� MEMBER
    INSERT INTO MEMBER(MID, BDATE, LOGIN_DATE, CATEGORY_S_ID)
    VALUES('M'|| V_MID, SYSDATE, SYSDATE, V_CATEGORY_S_ID_1);
    
    -- 2. INSERT �� MEMBERINFO
    INSERT INTO MEMBERINFO(ID, NAME, SSN, EMAIL, TEL, PWD, NICKNAME, URL, REGION_S_ID, MID, USERID) 
    VALUES('MI'|| MEMBERINFOSEQ.NEXTVAL, V_NAME, V_SSN, V_EMAIL, V_TEL
    , V_PWD, V_NICKNAME, V_URL, V_REGION_S_ID_1, 'M'||V_MID, V_USERID);
    
    -- Ŀ��
    COMMIT;
    
    -- ���� ó��
    EXCEPTION
        WHEN OTHERS THEN ROLLBACK;
END;
--==>> Procedure JOIN_INSERT��(��) �����ϵǾ����ϴ�.

--------------------------------------------------------------------------------
--�� Ʈ����

-- ��û�� �ִ� ��� ���� ���� Ʈ����
CREATE OR REPLACE TRIGGER BEE_DELETE
        BEFORE 
        DELETE ON BEE
        FOR EACH ROW
BEGIN    
    DELETE
    FROM BEE_REQ
    WHERE BEE_ID=:OLD.BEE_ID;
END;
--==>> Trigger BEE_DELETE��(��) �����ϵǾ����ϴ�.


-- ��û�� �ִ� ���
CREATE OR REPLACE TRIGGER BEE_REQ_DELETE
        BEFORE 
        DELETE ON BEE_REQ
        FOR EACH ROW
BEGIN
    DELETE
    FROM ABSENT
    WHERE REQ_ID=:OLD.REQ_ID;
END;
--==>> Trigger BEE_REQ_DELETE��(��) �����ϵǾ����ϴ�.






--------------------------------------------------------------------------------
--�� ������ ���� ���ν���

--�� �����Խ��� �Խñ� ����
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
            V_TITLE := V_NICKNAME || ' ��õ ���!';
        ELSIF (MOD(V_NUM, 3)=0) THEN
            V_TITLE := '�ȳ��ϼ���. ' || V_NICKNAME || '�Դϴ�~~';
        ELSIF (MOD(V_NUM, 5)=0) THEN
            V_TITLE := V_NICKNAME || '��(��) �ۼ��� �Խù��Դϴ�.';
        ELSIF (MOD(V_NUM, 9)=0) THEN
            V_TITLE := V_NICKNAME || ', �� �г��� �����?';
        ELSIF (MOD(V_NUM, 7)=0) THEN
            V_TITLE := '���� ���׿� ��ô� �� ã�ƿ�! ����' || V_NICKNAME || '�Դϴ�!';
        ELSIF (MOD(V_NUM, 4)=0) THEN
            V_TITLE := '���Ƹ� ���� ' || V_NICKNAME || '��(��) �˷��帱���?';
        ELSE
            V_TITLE := '�Խ��� �̷��� ���� �� ����?';
        END IF;
        
        V_CONTENT := V_TITLE || ' ������ �̴̰ϴ�! ������ ���߿� �߰��ҰԿ�!!!!';
        
        -- ��¥ SYSDATE�� ������, ��ȸ���� ����Ʈ��
        INSERT INTO FREE_B(B_ID, MID, TITLE, CONTENT, BDATE)
        VALUES(FREE_BSEQ.NEXTVAL, V_MID, V_TITLE, V_CONTENT, V_BDATE);
    END LOOP;
END;
--==>> PL/SQL ���ν����� ���������� �Ϸ�Ǿ����ϴ�.




--�� ī�װ��� �Խ���
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
            V_TITLE := V_S_CAT || ' ���?';
        ELSIF (MOD(V_NUM, 3)=0) THEN
            V_TITLE := '�ȳ��ϼ���. ' || V_S_CAT || ' ���� �ؿ�!';
        ELSIF (MOD(V_NUM, 5)=0) THEN
            V_TITLE := V_S_CAT || ' �ϱ⿡ �� ���� �� �־��???';
        ELSIF (MOD(V_NUM, 9)=0) THEN
            V_TITLE := V_S_CAT || '... �� �� �ϰ� �;��...';
        ELSIF (MOD(V_NUM, 7)=0) THEN
            V_TITLE := '���� ��� ���� �� ã�ƿ�! ' || V_S_CAT || ' ���� �ؿ�!';
        ELSIF (MOD(V_NUM, 11)=0) THEN
            V_TITLE := '�� ���� ���� ��� �˷��帳�ϴ�!!!!';
        ELSE
            V_TITLE := 'ī�װ��� �Խ��� �̷��� ���� �� ����?';
        END IF;
        
        V_CONTENT := V_TITLE || ' ������ �̴̰ϴ�! ������ ���߿� �߰��ҰԿ�!!!!';
        
        -- ��¥ SYSDATE�� ������, ��ȸ���� ����Ʈ��
        INSERT INTO CATEGORY_B(B_ID, CATEGORY_S_ID, MID, TITLE, CONTENT, BDATE)
        VALUES(CATEGORY_BSEQ.NEXTVAL, V_CATEGORY_S_ID, V_MID, V_TITLE, V_CONTENT, V_BDATE);
    END LOOP;
END;
--==>> PL/SQL ���ν����� ���������� �Ϸ�Ǿ����ϴ�.




--�� ���� ������ ����
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
        
        V_BEE_TIME := ADD_MONTHS(V_BEE_TIME, 1); -- ���ӳ�¥
        V_BDATE := ADD_MONTHS(V_BDATE, 1); -- �ۼ���
        
        
        V_TITLE := TO_CHAR(V_NUM) || 'ȸ�� ��������Դϴ�!';
        
        V_CONTENT := TO_CHAR(V_NUM) || '��° �����̳׿�. ������� �� �������ּ���!';
        
        -- �켱 ���� NULL, ��ġ '0'���� �־���. �ּ��ο� 3��, �ִ��ο��� NULL
        INSERT INTO BEE(BEE_ID, TYPE_ID, TITLE, CLUBMEM_ID, CONTENT, BEE_TIME, WEATHER, LOCATION, MIN, MAX, FEE, BDATE)
        VALUES(BEESEQ.NEXTVAL, '1', V_TITLE, 'CM1', V_CONTENT, V_BEE_TIME, NULL, '0', 3, NULL, V_FEE, V_BDATE);
    END LOOP;
END;
--==>> PL/SQL ���ν����� ���������� �Ϸ�Ǿ����ϴ�.



--�� ���� ������ ������ ����(���Ƹ���)
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
        
        
        -- �켱 ���� NULL, ��ġ '0'���� �־���. �ּ��ο� 3��, �ִ��ο��� NULL
        INSERT INTO BEE_REQ(REQ_ID, CLUBMEM_ID, BEE_ID, BDATE)
        VALUES(BEE_REQSEQ.NEXTVAL, 'CM1', V_NUM, V_BDATE + 2);
    END LOOP;
END;



--�� ���� ������ ������ ����(���Ƹ���)
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
        
        
        -- �켱 ���� NULL, ��ġ '0'���� �־���. �ּ��ο� 3��, �ִ��ο��� NULL
        INSERT INTO BEE_REQ(REQ_ID, CLUBMEM_ID, BEE_ID, BDATE)
        VALUES(BEE_REQSEQ.NEXTVAL, 'CM14', V_NUM, V_BDATE + 3);
    END LOOP;
END;




