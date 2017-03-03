set client_encoding=UTF8;

/*id: user
  description: 用戶
  comment: 
 */
create view public.V0301 as
select *,
public.V0301_USLSNAME(t) USLSNAME
from public.F0301 t;

/*id: certificate
  description: 證書
  comment: 
 */
create view public.V0331 as
select *,
public.V0331_CRLSNAME(t) CRLSNAME,
public.V0331_CRLSLOC(t) CRLSLOC
from public.F0331 t;

/*id: article
  description: 文章
  comment: 
 */
create view public.V1110 as
select *,
public.V1110_ATBRF(t) ATBRF,
public.V1110_ATCSA(t) ATCSA,
public.V1110_ATCSB(t) ATCSB,
public.V1110_ATCSC(t) ATCSC,
public.V1110_ATCSD(t) ATCSD,
public.V1110_ATCSE(t) ATCSE,
public.V1110_ATCSF(t) ATCSF
from public.F1110 t;

/*id: sentence
  description: 文句
  comment: 
 */
create view public.V1120 as
select *,
public.V1120_ASCS(t) ASCS
from public.F1120 t;