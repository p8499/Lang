set client_encoding=UTF8;


/*id: language
  description: 語言
  comment: 
 */
create table PUBLIC.F1010(
    /*語言編碼*/
    LSID VARCHAR(16) NOT NULL,
    /*語言名稱*/
    LSNAME VARCHAR(16) NOT NULL,
    /*學術名*/
    LSLOC VARCHAR(128) NOT NULL,
    /*排序號*/
    LSSORT SMALLINT NOT NULL
);
ALTER TABLE PUBLIC.F1010 ADD CONSTRAINT LANGUAGE_PRIMARY PRIMARY KEY (LSID);


/*id: user
  description: 用戶
  comment: 
 */
create table PUBLIC.F0301(
    /*用戶名*/
    USID VARCHAR(16) NOT NULL,
    /*密碼*/
    USPSWD VARCHAR(32) NOT NULL,
    /*昵稱*/
    USNAME VARCHAR(16) NOT NULL,
    /*狀態*/
    USST SMALLINT NOT NULL,
    /*語言編碼*/
    USLSID VARCHAR(16) NOT NULL,
    /*單位能量*/
    USPN SMALLINT NOT NULL
);
ALTER TABLE PUBLIC.F0301 ADD CONSTRAINT USER_PRIMARY PRIMARY KEY (USID);
ALTER TABLE PUBLIC.F0301 ADD CONSTRAINT USER_REFERENCE_0 FOREIGN KEY (USLSID) REFERENCES PUBLIC.F1010 (LSID);


/*id: usercreation
  description: 用戶創建
  comment: 
 */
create table PUBLIC.F0309(
    /*創建編碼*/
    UCID SERIAL NOT NULL,
    /*創建辰光*/
    UCCRDD TIMESTAMP NOT NULL,
    /*目標用戶名*/
    UCUSID VARCHAR(16) NOT NULL,
    /*圖片驗證碼*/
    UCPV VARCHAR(6) NOT NULL,
    /*短信驗證碼*/
    UCMV VARCHAR(6) NOT NULL,
    /*狀態*/
    UCST SMALLINT NOT NULL
);
ALTER TABLE PUBLIC.F0309 ADD CONSTRAINT USERCREATION_PRIMARY PRIMARY KEY (UCID);
ALTER TABLE PUBLIC.F0309 ADD CONSTRAINT USERCREATION_REFERENCE_0 FOREIGN KEY (UCUSID) REFERENCES PUBLIC.F0301 (USID);


/*id: role
  description: 角色
  comment: 
 */
create table PUBLIC.F0310(
    /*角色編碼*/
    RLID VARCHAR(8) NOT NULL,
    /*角色名稱*/
    RLNAME VARCHAR(16) NOT NULL
);
ALTER TABLE PUBLIC.F0310 ADD CONSTRAINT ROLE_PRIMARY PRIMARY KEY (RLID);


/*id: userrole
  description: 用戶角色
  comment: 
 */
create table PUBLIC.F0311(
    /*編碼*/
    URID SERIAL NOT NULL,
    /*用戶名*/
    URUSID VARCHAR(16) NOT NULL,
    /*角色編碼*/
    URRLID VARCHAR(8) NOT NULL
);
ALTER TABLE PUBLIC.F0311 ADD CONSTRAINT USERROLE_PRIMARY PRIMARY KEY (URID);
ALTER TABLE PUBLIC.F0311 ADD CONSTRAINT USERROLE_UNIQUE_0 UNIQUE (URUSID,URRLID);
ALTER TABLE PUBLIC.F0311 ADD CONSTRAINT USERROLE_REFERENCE_0 FOREIGN KEY (URUSID) REFERENCES PUBLIC.F0301 (USID);
ALTER TABLE PUBLIC.F0311 ADD CONSTRAINT USERROLE_REFERENCE_1 FOREIGN KEY (URRLID) REFERENCES PUBLIC.F0310 (RLID);


/*id: authority
  description: 權限
  comment: 
 */
create table PUBLIC.F0320(
    /*權限編碼*/
    AUID VARCHAR(8) NOT NULL,
    /*權限名稱*/
    AUNAME VARCHAR(16) NOT NULL
);
ALTER TABLE PUBLIC.F0320 ADD CONSTRAINT AUTHORITY_PRIMARY PRIMARY KEY (AUID);


/*id: roleauthority
  description: 角色權限
  comment: 
 */
create table PUBLIC.F0321(
    /*編碼*/
    RAID SERIAL NOT NULL,
    /*角色編碼*/
    RARLID VARCHAR(8) NOT NULL,
    /*權限編碼*/
    RAAUID VARCHAR(8) NOT NULL
);
ALTER TABLE PUBLIC.F0321 ADD CONSTRAINT ROLEAUTHORITY_PRIMARY PRIMARY KEY (RAID);
ALTER TABLE PUBLIC.F0321 ADD CONSTRAINT ROLEAUTHORITY_UNIQUE_0 UNIQUE (RARLID,RAAUID);
ALTER TABLE PUBLIC.F0321 ADD CONSTRAINT ROLEAUTHORITY_REFERENCE_0 FOREIGN KEY (RAAUID) REFERENCES PUBLIC.F0320 (AUID);
ALTER TABLE PUBLIC.F0321 ADD CONSTRAINT ROLEAUTHORITY_REFERENCE_1 FOREIGN KEY (RARLID) REFERENCES PUBLIC.F0310 (RLID);


/*id: dictionary
  description: 字典
  comment: 每種語言之標準發音字典
 */
create table PUBLIC.F1011(
    /*字典編碼*/
    DCID SERIAL NOT NULL,
    /*語言編碼*/
    DCLSID VARCHAR(16) NOT NULL,
    /*漢字*/
    DCHZ VARCHAR(4) NOT NULL,
    /*拼音聲調*/
    DCPT VARCHAR(32) NOT NULL,
    /*備註*/
    DCRM VARCHAR(64) NOT NULL
);
ALTER TABLE PUBLIC.F1011 ADD CONSTRAINT DICTIONARY_PRIMARY PRIMARY KEY (DCID);
ALTER TABLE PUBLIC.F1011 ADD CONSTRAINT DICTIONARY_UNIQUE_0 UNIQUE (DCLSID,DCPT,DCHZ);
ALTER TABLE PUBLIC.F1011 ADD CONSTRAINT DICTIONARY_REFERENCE_0 FOREIGN KEY (DCLSID) REFERENCES PUBLIC.F1010 (LSID);


/*id: category
  description: 分類
  comment: 
 */
create table PUBLIC.F1030(
    /*分類編碼*/
    CGID SERIAL NOT NULL,
    /*語言編碼*/
    CGLSID VARCHAR(16) NOT NULL,
    /*子項號*/
    CGSI INTEGER NOT NULL,
    /*父項號*/
    CGPSI INTEGER NOT NULL,
    /*分類名稱*/
    CGNAME VARCHAR(16) NOT NULL
);
ALTER TABLE PUBLIC.F1030 ADD CONSTRAINT CATEGORY_PRIMARY PRIMARY KEY (CGID);
ALTER TABLE PUBLIC.F1030 ADD CONSTRAINT CATEGORY_UNIQUE_0 UNIQUE (CGLSID,CGSI);
ALTER TABLE PUBLIC.F1030 ADD CONSTRAINT CATEGORY_REFERENCE_0 FOREIGN KEY (CGLSID) REFERENCES PUBLIC.F1010 (LSID);


/*id: article
  description: 文章
  comment: 
 */
create table PUBLIC.F1110(
    /*文章編碼*/
    ATID SERIAL NOT NULL,
    /*分類編碼*/
    ATCGID INTEGER NOT NULL,
    /*子項號*/
    ATSI INTEGER NOT NULL,
    /*文章名稱*/
    ATNAME VARCHAR(16) NOT NULL,
    /*擁有者*/
    ATUSID VARCHAR(16) NOT NULL,
    /*創建辰光*/
    ATCRDT TIMESTAMP NOT NULL,
    /*更新辰光*/
    ATUPDT TIMESTAMP NOT NULL
);
ALTER TABLE PUBLIC.F1110 ADD CONSTRAINT ARTICLE_PRIMARY PRIMARY KEY (ATID);
ALTER TABLE PUBLIC.F1110 ADD CONSTRAINT ARTICLE_UNIQUE_0 UNIQUE (ATCGID,ATSI);
ALTER TABLE PUBLIC.F1110 ADD CONSTRAINT ARTICLE_REFERENCE_0 FOREIGN KEY (ATCGID) REFERENCES PUBLIC.F1030 (CGID);
ALTER TABLE PUBLIC.F1110 ADD CONSTRAINT ARTICLE_REFERENCE_1 FOREIGN KEY (ATUSID) REFERENCES PUBLIC.F0301 (USID);


/*id: sentence
  description: 文句
  comment: 
 */
create table PUBLIC.F1120(
    /*文句編碼*/
    ASID SERIAL NOT NULL,
    /*文章編碼*/
    ASATID INTEGER NOT NULL,
    /*子項號*/
    ASSI INTEGER NOT NULL,
    /*內容*/
    ASCONT VARCHAR(64) NOT NULL,
    /*狀態*/
    ASST SMALLINT NOT NULL,
    /*擁有者*/
    ASUSID VARCHAR(16) NOT NULL,
    /*創建辰光*/
    ASCRDT TIMESTAMP NOT NULL,
    /*更新辰光*/
    ASUPDT TIMESTAMP NOT NULL
);
ALTER TABLE PUBLIC.F1120 ADD CONSTRAINT SENTENCE_PRIMARY PRIMARY KEY (ASID);
ALTER TABLE PUBLIC.F1120 ADD CONSTRAINT SENTENCE_UNIQUE_0 UNIQUE (ASATID,ASSI);
ALTER TABLE PUBLIC.F1120 ADD CONSTRAINT SENTENCE_REFERENCE_0 FOREIGN KEY (ASATID) REFERENCES PUBLIC.F1110 (ATID);
ALTER TABLE PUBLIC.F1120 ADD CONSTRAINT SENTENCE_REFERENCE_1 FOREIGN KEY (ASUSID) REFERENCES PUBLIC.F0301 (USID);


/*id: segment
  description: 分段
  comment: 
 */
create table PUBLIC.F1130(
    /*文句編碼*/
    TRASID INTEGER NOT NULL,
    /*拼音聲調*/
    TRPI VARCHAR(512) NOT NULL,
    /*漢字*/
    TRHZ VARCHAR(64) NOT NULL,
    /*狀態*/
    TRST SMALLINT NOT NULL,
    /*擁有者*/
    TRUSID VARCHAR(16) NOT NULL,
    /*創建辰光*/
    TRCRDT TIMESTAMP NOT NULL,
    /*更新辰光*/
    TRUPDT TIMESTAMP NOT NULL
);
ALTER TABLE PUBLIC.F1130 ADD CONSTRAINT SEGMENT_PRIMARY PRIMARY KEY (TRASID);
ALTER TABLE PUBLIC.F1130 ADD CONSTRAINT SEGMENT_REFERENCE_0 FOREIGN KEY (TRASID) REFERENCES PUBLIC.F1120 (ASID);
ALTER TABLE PUBLIC.F1130 ADD CONSTRAINT SEGMENT_REFERENCE_1 FOREIGN KEY (TRUSID) REFERENCES PUBLIC.F0301 (USID);


/*id: segmentflow
  description: 分段線程
  comment: 
 */
create table PUBLIC.F1131(
    /*線程編碼*/
    TAID SERIAL NOT NULL,
    /*文句編碼*/
    TAASID INTEGER NOT NULL,
    /*子項號*/
    TASI INTEGER NOT NULL,
    /*拼音聲調*/
    TAPI VARCHAR(512) NOT NULL,
    /*漢字*/
    TAHZ VARCHAR(64) NOT NULL,
    /*狀態*/
    TAST SMALLINT NOT NULL,
    /*擁有者*/
    TAUSID VARCHAR(16) NOT NULL,
    /*創建辰光*/
    TACRDT TIMESTAMP NOT NULL,
    /*更新辰光*/
    TAUPDT TIMESTAMP NOT NULL
);
ALTER TABLE PUBLIC.F1131 ADD CONSTRAINT SEGMENTFLOW_PRIMARY PRIMARY KEY (TAID);
ALTER TABLE PUBLIC.F1131 ADD CONSTRAINT SEGMENTFLOW_UNIQUE_0 UNIQUE (TAASID,TASI);
ALTER TABLE PUBLIC.F1131 ADD CONSTRAINT SEGMENTFLOW_REFERENCE_0 FOREIGN KEY (TAASID) REFERENCES PUBLIC.F1120 (ASID);
ALTER TABLE PUBLIC.F1131 ADD CONSTRAINT SEGMENTFLOW_REFERENCE_1 FOREIGN KEY (TAUSID) REFERENCES PUBLIC.F0301 (USID);


/*id: segmentvote
  description: 分段投票
  comment: 
 */
create table PUBLIC.F1132(
    /*投票編碼*/
    TVID SERIAL NOT NULL,
    /*線程編碼*/
    TVTAID INTEGER NOT NULL,
    /*子項號*/
    TVSI INTEGER NOT NULL,
    /*擁有者*/
    TVUSID VARCHAR(16) NOT NULL,
    /*能量*/
    TVPO SMALLINT NOT NULL,
    /*創建辰光*/
    TVCRDT TIMESTAMP NOT NULL,
    /*更新辰光*/
    TVUPDT TIMESTAMP NOT NULL
);
ALTER TABLE PUBLIC.F1132 ADD CONSTRAINT SEGMENTVOTE_PRIMARY PRIMARY KEY (TVID);
ALTER TABLE PUBLIC.F1132 ADD CONSTRAINT SEGMENTVOTE_UNIQUE_0 UNIQUE (TVTAID,TVSI);
ALTER TABLE PUBLIC.F1132 ADD CONSTRAINT SEGMENTVOTE_UNIQUE_1 UNIQUE (TVTAID,TVUSID);
ALTER TABLE PUBLIC.F1132 ADD CONSTRAINT SEGMENTVOTE_REFERENCE_0 FOREIGN KEY (TVTAID) REFERENCES PUBLIC.F1131 (TAID);
ALTER TABLE PUBLIC.F1132 ADD CONSTRAINT SEGMENTVOTE_REFERENCE_1 FOREIGN KEY (TVUSID) REFERENCES PUBLIC.F0301 (USID);


/*id: word
  description: 詞音
  comment: 單音節單字、單音節多字、多音節多字。從分段、字典提取而來，連續變調之建議依據。
此表內容應由引擎自動生成
 */
create table PUBLIC.F1040(
    /*詞音編碼*/
    WOID SERIAL NOT NULL,
    /*語言編碼*/
    WOLSID VARCHAR(16) NOT NULL,
    /*拼音聲調*/
    WOPT VARCHAR(64) NOT NULL,
    /*漢字*/
    WOHZ VARCHAR(8) NOT NULL,
    /*類別*/
    WOCL VARCHAR(1) NOT NULL,
    /*狀態*/
    WOST SMALLINT NOT NULL,
    /*來源*/
    WOSR VARCHAR(1) NOT NULL,
    /*排序號*/
    WOSORT SMALLINT NOT NULL,
    /*創建辰光*/
    WOCRDT TIMESTAMP NOT NULL,
    /*更新辰光*/
    WOUPDT TIMESTAMP NOT NULL
);
ALTER TABLE PUBLIC.F1040 ADD CONSTRAINT WORD_PRIMARY PRIMARY KEY (WOID);
ALTER TABLE PUBLIC.F1040 ADD CONSTRAINT WORD_UNIQUE_0 UNIQUE (WOLSID,WOPT,WOHZ);
ALTER TABLE PUBLIC.F1040 ADD CONSTRAINT WORD_REFERENCE_0 FOREIGN KEY (WOLSID) REFERENCES PUBLIC.F1010 (LSID);