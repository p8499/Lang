set client_encoding=UTF8;

/*id: article
  description: 文章
  comment: 
 */
create view PUBLIC.V1110 as
select *,
PUBLIC.L1110_ATCGNAME(t) ATCGNAME,
PUBLIC.L1110_ATUSNAME(t) ATUSNAME,
PUBLIC.L1110_ATBRF(t) ATBRF,
PUBLIC.L1110_ATCSA(t) ATCSA,
PUBLIC.L1110_ATCSB(t) ATCSB,
PUBLIC.L1110_ATCSC(t) ATCSC,
PUBLIC.L1110_ATCSD(t) ATCSD,
PUBLIC.L1110_ATCSE(t) ATCSE,
PUBLIC.L1110_ATCSF(t) ATCSF
from PUBLIC.F1110 t;

/*id: sentence
  description: 文句
  comment: 
 */
create view PUBLIC.V1120 as
select *,
PUBLIC.L1120_ASCS(t) ASCS
from PUBLIC.F1120 t;