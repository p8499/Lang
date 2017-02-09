cd %~dp0
psql -U postgres -c "CREATE DATABASE lang"
psql -U postgres -d lang -f ./db_tabl.sql
set /p db_func=Please enter function file, for example db_func.sql:
psql -U postgres -d lang -f ./%db_func%
psql -U postgres -d lang -f ./db_view.sql
psql -U postgres -d lang -f ./db_data.sql

pause