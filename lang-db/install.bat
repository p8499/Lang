cd %~dp0
psql -E -U postgres -c "CREATE DATABASE lang"
psql -E -U postgres -d lang -f ./local_db_tabl.sql
psql -E -U postgres -d lang -f ./local_db_func.sql
psql -E -U postgres -d lang -f ./local_db_view.sql
psql -E -U postgres -d lang -f ./local_db_data.sql

pause