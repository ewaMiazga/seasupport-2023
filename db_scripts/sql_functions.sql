create or replace function get_active_visit(login_user Varchar2)
return number
as
    visit_id number;
    current_date date;
begin
    select sysdate
    into current_date
    from DUAL;

    select v.VISIT_ID
    into visit_id
    from VISITS v
    where v.LOGIN = login_user and
    current_date > DATE_BEGIN and
    current_date < DATE_END;

    return visit_id;
end;