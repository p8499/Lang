cd %~dp0
psql -U postgres -c "DROP DATABASE IF EXISTS lang"
pause