set client_encoding=UTF8;


/*id: language
  description: 語言
  comment: 
 */
create table public.F1010(
    /*語言編碼*/
    LSID VARCHAR(16) NOT NULL,
    /*語言名稱*/
    LSNAME VARCHAR(16) NOT NULL,
    /*學術名*/
    LSLOC VARCHAR(128) NOT NULL,
    /*排序號*/
    LSSORT SMALLINT NOT NULL
);
ALTER TABLE public.F1010 ADD CONSTRAINT LANGUAGE_PRIMARY PRIMARY KEY (LSID);
ALTER TABLE public.F1010 ADD CONSTRAINT LANGUAGE_UNIQUE_0 UNIQUE (LSID);


/*id: user
  description: 用戶
  comment: 
 */
create table public.F0301(
    /*用戶名*/
    USID SERIAL NOT NULL,
    /*手機號頭*/
    USCELL VARCHAR(16) NOT NULL,
    /*密碼*/
    USPSWD VARCHAR(32) NOT NULL,
    /*昵稱*/
    USNAME VARCHAR(16) NOT NULL,
    /*狀態*/
    USST SMALLINT NOT NULL,
    /*語言編碼*/
    USLSID VARCHAR(16) NOT NULL
);
ALTER TABLE public.F0301 ADD CONSTRAINT USER_PRIMARY PRIMARY KEY (USID);
ALTER TABLE public.F0301 ADD CONSTRAINT USER_UNIQUE_0 UNIQUE (USID);
ALTER TABLE public.F0301 ADD CONSTRAINT USER_UNIQUE_1 UNIQUE (USCELL);
ALTER TABLE public.F0301 ADD CONSTRAINT USER_REFERENCE_0 FOREIGN KEY (USLSID) REFERENCES public.F1010 (LSID);


/*id: usercreation
  description: 用戶創建
  comment: 
 */
create table public.F0309(
    /*創建編碼*/
    UCID SERIAL NOT NULL,
    /*創建辰光*/
    UCCRDT TIMESTAMP NOT NULL,
    /*更新辰光*/
    UCUPDT TIMESTAMP NOT NULL,
    /*目標手機號頭*/
    UCCELL VARCHAR(16) NOT NULL,
    /*圖片驗證碼*/
    UCPV VARCHAR(6) NOT NULL,
    /*短信驗證碼*/
    UCMV VARCHAR(6),
    /*動作*/
    UCAC SMALLINT NOT NULL,
    /*失效狀態*/
    UCST SMALLINT NOT NULL
);
ALTER TABLE public.F0309 ADD CONSTRAINT USERCREATION_PRIMARY PRIMARY KEY (UCID);
ALTER TABLE public.F0309 ADD CONSTRAINT USERCREATION_UNIQUE_0 UNIQUE (UCID);


/*id: role
  description: 角色
  comment: 
 */
create table public.F0310(
    /*角色編碼*/
    RLID VARCHAR(8) NOT NULL,
    /*角色名稱*/
    RLNAME VARCHAR(16) NOT NULL
);
ALTER TABLE public.F0310 ADD CONSTRAINT ROLE_PRIMARY PRIMARY KEY (RLID);
ALTER TABLE public.F0310 ADD CONSTRAINT ROLE_UNIQUE_0 UNIQUE (RLID);


/*id: userrole
  description: 用戶角色
  comment: 
 */
create table public.F0311(
    /*編碼*/
    URID SERIAL NOT NULL,
    /*用戶名*/
    URUSID INTEGER NOT NULL,
    /*角色編碼*/
    URRLID VARCHAR(8) NOT NULL
);
ALTER TABLE public.F0311 ADD CONSTRAINT USERROLE_PRIMARY PRIMARY KEY (URID);
ALTER TABLE public.F0311 ADD CONSTRAINT USERROLE_UNIQUE_0 UNIQUE (URID);
ALTER TABLE public.F0311 ADD CONSTRAINT USERROLE_UNIQUE_1 UNIQUE (URUSID,URRLID);
ALTER TABLE public.F0311 ADD CONSTRAINT USERROLE_REFERENCE_0 FOREIGN KEY (URUSID) REFERENCES public.F0301 (USID);
ALTER TABLE public.F0311 ADD CONSTRAINT USERROLE_REFERENCE_1 FOREIGN KEY (URRLID) REFERENCES public.F0310 (RLID);


/*id: authority
  description: 權限
  comment: 
 */
create table public.F0320(
    /*權限編碼*/
    AUID VARCHAR(16) NOT NULL,
    /*權限名稱*/
    AUNAME VARCHAR(16) NOT NULL
);
ALTER TABLE public.F0320 ADD CONSTRAINT AUTHORITY_PRIMARY PRIMARY KEY (AUID);
ALTER TABLE public.F0320 ADD CONSTRAINT AUTHORITY_UNIQUE_0 UNIQUE (AUID);


/*id: roleauthority
  description: 角色權限
  comment: 
 */
create table public.F0321(
    /*編碼*/
    RAID SERIAL NOT NULL,
    /*角色編碼*/
    RARLID VARCHAR(8) NOT NULL,
    /*權限編碼*/
    RAAUID VARCHAR(16) NOT NULL
);
ALTER TABLE public.F0321 ADD CONSTRAINT ROLEAUTHORITY_PRIMARY PRIMARY KEY (RAID);
ALTER TABLE public.F0321 ADD CONSTRAINT ROLEAUTHORITY_UNIQUE_0 UNIQUE (RAID);
ALTER TABLE public.F0321 ADD CONSTRAINT ROLEAUTHORITY_UNIQUE_1 UNIQUE (RARLID,RAAUID);
ALTER TABLE public.F0321 ADD CONSTRAINT ROLEAUTHORITY_REFERENCE_0 FOREIGN KEY (RAAUID) REFERENCES public.F0320 (AUID);
ALTER TABLE public.F0321 ADD CONSTRAINT ROLEAUTHORITY_REFERENCE_1 FOREIGN KEY (RARLID) REFERENCES public.F0310 (RLID);


/*id: certificate
  description: 證書
  comment: 
 */
create table public.F0331(
    /*證書編碼*/
    CRID SERIAL NOT NULL,
    /*用戶名*/
    CRUSID INTEGER NOT NULL,
    /*語言編碼*/
    CRLSID VARCHAR(16) NOT NULL,
    /*等級*/
    CRLV SMALLINT NOT NULL,
    /*生效日腳*/
    CREFDT TIMESTAMP NOT NULL,
    /*失效日腳*/
    CREXDT TIMESTAMP NOT NULL
);
ALTER TABLE public.F0331 ADD CONSTRAINT CERTIFICATE_PRIMARY PRIMARY KEY (CRID);
ALTER TABLE public.F0331 ADD CONSTRAINT CERTIFICATE_UNIQUE_0 UNIQUE (CRID);
ALTER TABLE public.F0331 ADD CONSTRAINT CERTIFICATE_REFERENCE_0 FOREIGN KEY (CRUSID) REFERENCES public.F0301 (USID);
ALTER TABLE public.F0331 ADD CONSTRAINT CERTIFICATE_REFERENCE_1 FOREIGN KEY (CRLSID) REFERENCES public.F1010 (LSID);


/*id: dictionary
  description: 字典
  comment: 每種語言之標準發音字典
 */
create table public.F1011(
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
ALTER TABLE public.F1011 ADD CONSTRAINT DICTIONARY_PRIMARY PRIMARY KEY (DCID);
ALTER TABLE public.F1011 ADD CONSTRAINT DICTIONARY_UNIQUE_0 UNIQUE (DCID);
ALTER TABLE public.F1011 ADD CONSTRAINT DICTIONARY_UNIQUE_1 UNIQUE (DCLSID,DCPT,DCHZ);
ALTER TABLE public.F1011 ADD CONSTRAINT DICTIONARY_REFERENCE_0 FOREIGN KEY (DCLSID) REFERENCES public.F1010 (LSID);


/*id: category
  description: 分類
  comment: 
 */
create table public.F1030(
    /*分類編碼*/
    CGID SERIAL NOT NULL,
    /*語言編碼*/
    CGLSID VARCHAR(16) NOT NULL,
    /*子項號*/
    CGSI INTEGER NOT NULL,
    /*父項號*/
    CGPSI INTEGER NOT NULL,
    /*擁有者*/
    CGUSID INTEGER NOT NULL,
    /*分類名稱*/
    CGNAME VARCHAR(16) NOT NULL
);
ALTER TABLE public.F1030 ADD CONSTRAINT CATEGORY_PRIMARY PRIMARY KEY (CGID);
ALTER TABLE public.F1030 ADD CONSTRAINT CATEGORY_UNIQUE_0 UNIQUE (CGID);
ALTER TABLE public.F1030 ADD CONSTRAINT CATEGORY_UNIQUE_1 UNIQUE (CGLSID,CGUSID,CGSI);
ALTER TABLE public.F1030 ADD CONSTRAINT CATEGORY_REFERENCE_0 FOREIGN KEY (CGLSID) REFERENCES public.F1010 (LSID);


/*id: word
  description: 詞音
  comment: 單音節單字、單音節多字、多音節多字。從分段、字典提取而來，連續變調之建議依據。
此表內容應由引擎自動生成
 */
create table public.F1040(
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
ALTER TABLE public.F1040 ADD CONSTRAINT WORD_PRIMARY PRIMARY KEY (WOID);
ALTER TABLE public.F1040 ADD CONSTRAINT WORD_UNIQUE_0 UNIQUE (WOID);
ALTER TABLE public.F1040 ADD CONSTRAINT WORD_UNIQUE_1 UNIQUE (WOLSID,WOPT,WOHZ);
ALTER TABLE public.F1040 ADD CONSTRAINT WORD_REFERENCE_0 FOREIGN KEY (WOLSID) REFERENCES public.F1010 (LSID);


/*id: article
  description: 文章
  comment: 
 */
create table public.F1110(
    /*文章編碼*/
    ATID SERIAL NOT NULL,
    /*分類編碼*/
    ATCGID INTEGER NOT NULL,
    /*子項號*/
    ATSI INTEGER NOT NULL,
    /*文章名稱*/
    ATNAME VARCHAR(16) NOT NULL,
    /*擁有者*/
    ATUSID INTEGER NOT NULL,
    /*創建辰光*/
    ATCRDT TIMESTAMP NOT NULL,
    /*更新辰光*/
    ATUPDT TIMESTAMP NOT NULL
);
ALTER TABLE public.F1110 ADD CONSTRAINT ARTICLE_PRIMARY PRIMARY KEY (ATID);
ALTER TABLE public.F1110 ADD CONSTRAINT ARTICLE_UNIQUE_0 UNIQUE (ATID);
ALTER TABLE public.F1110 ADD CONSTRAINT ARTICLE_UNIQUE_1 UNIQUE (ATCGID,ATSI);
ALTER TABLE public.F1110 ADD CONSTRAINT ARTICLE_REFERENCE_0 FOREIGN KEY (ATCGID) REFERENCES public.F1030 (CGID);
ALTER TABLE public.F1110 ADD CONSTRAINT ARTICLE_REFERENCE_1 FOREIGN KEY (ATUSID) REFERENCES public.F0301 (USID);


/*id: sentence
  description: 文句
  comment: 
 */
create table public.F1120(
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
    ASUSID INTEGER NOT NULL,
    /*創建辰光*/
    ASCRDT TIMESTAMP NOT NULL,
    /*更新辰光*/
    ASUPDT TIMESTAMP NOT NULL
);
ALTER TABLE public.F1120 ADD CONSTRAINT SENTENCE_PRIMARY PRIMARY KEY (ASID);
ALTER TABLE public.F1120 ADD CONSTRAINT SENTENCE_UNIQUE_0 UNIQUE (ASATID,ASSI);
ALTER TABLE public.F1120 ADD CONSTRAINT SENTENCE_UNIQUE_1 UNIQUE (ASID);
ALTER TABLE public.F1120 ADD CONSTRAINT SENTENCE_REFERENCE_0 FOREIGN KEY (ASATID) REFERENCES public.F1110 (ATID);
ALTER TABLE public.F1120 ADD CONSTRAINT SENTENCE_REFERENCE_1 FOREIGN KEY (ASUSID) REFERENCES public.F0301 (USID);


/*id: segment
  description: 分段
  comment: 
 */
create table public.F1130(
    /*文句編碼*/
    TRASID INTEGER NOT NULL,
    /*拼音聲調*/
    TRPI VARCHAR(512) NOT NULL,
    /*漢字*/
    TRHZ VARCHAR(64) NOT NULL,
    /*狀態*/
    TRST SMALLINT NOT NULL,
    /*擁有者*/
    TRUSID INTEGER NOT NULL,
    /*創建辰光*/
    TRCRDT TIMESTAMP NOT NULL,
    /*更新辰光*/
    TRUPDT TIMESTAMP NOT NULL
);
ALTER TABLE public.F1130 ADD CONSTRAINT SEGMENT_PRIMARY PRIMARY KEY (TRASID);
ALTER TABLE public.F1130 ADD CONSTRAINT SEGMENT_UNIQUE_0 UNIQUE (TRASID);
ALTER TABLE public.F1130 ADD CONSTRAINT SEGMENT_REFERENCE_0 FOREIGN KEY (TRASID) REFERENCES public.F1120 (ASID);
ALTER TABLE public.F1130 ADD CONSTRAINT SEGMENT_REFERENCE_1 FOREIGN KEY (TRUSID) REFERENCES public.F0301 (USID);


/*id: segmentflow
  description: 分段線程
  comment: 
 */
create table public.F1131(
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
    TAUSID INTEGER NOT NULL,
    /*創建辰光*/
    TACRDT TIMESTAMP NOT NULL,
    /*更新辰光*/
    TAUPDT TIMESTAMP NOT NULL
);
ALTER TABLE public.F1131 ADD CONSTRAINT SEGMENTFLOW_PRIMARY PRIMARY KEY (TAID);
ALTER TABLE public.F1131 ADD CONSTRAINT SEGMENTFLOW_UNIQUE_0 UNIQUE (TAID);
ALTER TABLE public.F1131 ADD CONSTRAINT SEGMENTFLOW_UNIQUE_1 UNIQUE (TAASID,TASI);
ALTER TABLE public.F1131 ADD CONSTRAINT SEGMENTFLOW_REFERENCE_0 FOREIGN KEY (TAASID) REFERENCES public.F1120 (ASID);
ALTER TABLE public.F1131 ADD CONSTRAINT SEGMENTFLOW_REFERENCE_1 FOREIGN KEY (TAUSID) REFERENCES public.F0301 (USID);


/*id: segmentvote
  description: 分段投票
  comment: 
 */
create table public.F1132(
    /*投票編碼*/
    TVID SERIAL NOT NULL,
    /*線程編碼*/
    TVTAID INTEGER NOT NULL,
    /*子項號*/
    TVSI INTEGER NOT NULL,
    /*擁有者*/
    TVUSID INTEGER NOT NULL,
    /*能量*/
    TVPO SMALLINT NOT NULL,
    /*創建辰光*/
    TVCRDT TIMESTAMP NOT NULL,
    /*更新辰光*/
    TVUPDT TIMESTAMP NOT NULL
);
ALTER TABLE public.F1132 ADD CONSTRAINT SEGMENTVOTE_PRIMARY PRIMARY KEY (TVID);
ALTER TABLE public.F1132 ADD CONSTRAINT SEGMENTVOTE_UNIQUE_0 UNIQUE (TVID);
ALTER TABLE public.F1132 ADD CONSTRAINT SEGMENTVOTE_UNIQUE_1 UNIQUE (TVTAID,TVSI);
ALTER TABLE public.F1132 ADD CONSTRAINT SEGMENTVOTE_UNIQUE_2 UNIQUE (TVTAID,TVUSID);
ALTER TABLE public.F1132 ADD CONSTRAINT SEGMENTVOTE_REFERENCE_0 FOREIGN KEY (TVTAID) REFERENCES public.F1131 (TAID);
ALTER TABLE public.F1132 ADD CONSTRAINT SEGMENTVOTE_REFERENCE_1 FOREIGN KEY (TVUSID) REFERENCES public.F0301 (USID);


/*id: question
  description: 題目
  comment: 
 */
create table public.F1201(
    /*題目編碼*/
    TQID SERIAL NOT NULL,
    /*語言編碼*/
    TQLSID VARCHAR(16) NOT NULL,
    /*等級*/
    TQLV SMALLINT NOT NULL,
    /*類型*/
    TQTY VARCHAR(1) NOT NULL,
    /*內容*/
    TQCONT VARCHAR(128) NOT NULL,
    /*答案*/
    TQO VARCHAR(128) NOT NULL,
    /*狀態*/
    TQST SMALLINT NOT NULL
);
ALTER TABLE public.F1201 ADD CONSTRAINT QUESTION_PRIMARY PRIMARY KEY (TQID);
ALTER TABLE public.F1201 ADD CONSTRAINT QUESTION_UNIQUE_0 UNIQUE (TQID);
ALTER TABLE public.F1201 ADD CONSTRAINT QUESTION_REFERENCE_0 FOREIGN KEY (TQLSID) REFERENCES public.F1010 (LSID);


/*id: questionoption
  description: 題目選項
  comment: 
 */
create table public.F1202(
    /*選項編碼*/
    TOID SERIAL NOT NULL,
    /*題目編碼*/
    TOTQID INTEGER NOT NULL,
    /*代碼*/
    TOO VARCHAR(1) NOT NULL,
    /*內容*/
    TOCONT VARCHAR(32) NOT NULL
);
ALTER TABLE public.F1202 ADD CONSTRAINT QUESTIONOPTION_PRIMARY PRIMARY KEY (TOID);
ALTER TABLE public.F1202 ADD CONSTRAINT QUESTIONOPTION_UNIQUE_0 UNIQUE (TOID);
ALTER TABLE public.F1202 ADD CONSTRAINT QUESTIONOPTION_UNIQUE_1 UNIQUE (TOTQID,TOO);
ALTER TABLE public.F1202 ADD CONSTRAINT QUESTIONOPTION_REFERENCE_0 FOREIGN KEY (TOTQID) REFERENCES public.F1201 (TQID);


/*id: exam
  description: 測試
  comment: 
 */
create table public.F1211(
    /*測試編碼*/
    EXID SERIAL NOT NULL,
    /*用戶編碼*/
    EXUSID INTEGER NOT NULL,
    /*子項號*/
    EXSI INTEGER NOT NULL,
    /*語言編碼*/
    EXLSID VARCHAR(16) NOT NULL,
    /*等級*/
    EXLV SMALLINT NOT NULL,
    /*創建日腳*/
    EXCRDT TIMESTAMP NOT NULL,
    /*更改日腳*/
    EXUPDT TIMESTAMP NOT NULL,
    /*滿分*/
    EXTS SMALLINT NOT NULL,
    /*得分*/
    EXSC SMALLINT NOT NULL
);
ALTER TABLE public.F1211 ADD CONSTRAINT EXAM_PRIMARY PRIMARY KEY (EXID);
ALTER TABLE public.F1211 ADD CONSTRAINT EXAM_UNIQUE_0 UNIQUE (EXID);
ALTER TABLE public.F1211 ADD CONSTRAINT EXAM_UNIQUE_1 UNIQUE (EXUSID,EXSI);
ALTER TABLE public.F1211 ADD CONSTRAINT EXAM_REFERENCE_0 FOREIGN KEY (EXUSID) REFERENCES public.F0301 (USID);
ALTER TABLE public.F1211 ADD CONSTRAINT EXAM_REFERENCE_1 FOREIGN KEY (EXLSID) REFERENCES public.F1010 (LSID);


/*id: examquestion
  description: 測試題目
  comment: 
 */
create table public.F1212(
    /*測題編碼*/
    EQID SERIAL NOT NULL,
    /*測試編碼*/
    EQEXID INTEGER NOT NULL,
    /*子項號*/
    EQSI INTEGER NOT NULL,
    /*題目編碼*/
    EQTQID INTEGER NOT NULL,
    /*用戶答案*/
    EQO VARCHAR(128) NOT NULL,
    /*滿分*/
    EQTS SMALLINT NOT NULL,
    /*得分*/
    EQSC SMALLINT NOT NULL
);
ALTER TABLE public.F1212 ADD CONSTRAINT EXAMQUESTION_PRIMARY PRIMARY KEY (EQID);
ALTER TABLE public.F1212 ADD CONSTRAINT EXAMQUESTION_UNIQUE_0 UNIQUE (EQID);
ALTER TABLE public.F1212 ADD CONSTRAINT EXAMQUESTION_UNIQUE_1 UNIQUE (EQEXID,EQSI);
ALTER TABLE public.F1212 ADD CONSTRAINT EXAMQUESTION_UNIQUE_2 UNIQUE (EQEXID,EQTQID);
ALTER TABLE public.F1212 ADD CONSTRAINT EXAMQUESTION_REFERENCE_0 FOREIGN KEY (EQEXID) REFERENCES public.F1211 (EXID);
ALTER TABLE public.F1212 ADD CONSTRAINT EXAMQUESTION_REFERENCE_1 FOREIGN KEY (EQTQID) REFERENCES public.F1201 (TQID);