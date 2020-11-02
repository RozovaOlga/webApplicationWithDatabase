package by.grodno.home.webappsample.service;


public class SQL {

    public static final String SELECT_ALL = "SELECT * FROM public.usersbase c LEFT JOIN public.department b ON c.department = b.id";
    public static final String DELETE_BY_ID = "delete from public.usersbase where id = ?";
    public static final String INSERT = "INSERT INTO public.usersbase "
            + "(empl_name, empl_last_name, department, salary, birthdate,  male) VALUES (?,?,?,?,?,?)";
    public static final String UPDATE ="UPDATE public.usersbase set empl_name=?, empl_last_name=?, department=?,salary=?, birthdate=?,  male=? WHERE id = (?)";
    public static final String SELECT_USER_BY_ID = "select * from public.usersbase WHERE id = ?";

    public static final String SELECT_ALL_DEPARTMENT= "select * from public.department order by id";
    public static final String DELETE_BY_ID_DEPARTMENT = "delete from public.department where id = ?";
    public static final String INSERT_DEPARTMENT = "INSERT INTO public.department "
            + "(name,location) VALUES (?,?)";
    public static final String UPDATE_DEPARTMENT ="UPDATE public.department set name=?,location=? WHERE id = (?)";
    public static final String SELECT_DEPARTMENT_BY_ID = "select * from public.department WHERE id = ?";
    public static final String UNIQUE_NAME_DEPARTMENT = "SELECT  * FROM public.department where department.name=?";
    public static final String USERS_DEPARTMENT = "SELECT * FROM public.usersbase  where usersbase.department = ?";
}
