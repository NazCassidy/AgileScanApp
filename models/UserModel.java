package agilegroup6.com.agilescanapp.models;
/**
 * Created by liamfriel on 25/02/2016.
 */
public class UserModel
{
    //User details
    private String id;
    private String accesslevel;
    private String sessioncookie;

    //Accessor/mutator methods
    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setAccesslevel(String accesslevel)
    {
        this.accesslevel = accesslevel;
    }

    public String getAccesslevel()
    {
        return this.accesslevel;
    }

    public void setSessioncookie(String cookie)
    {
        this.sessioncookie = cookie;
    }

    public String getSessioncookie()
    {
        return this.sessioncookie;
    }


    public void UserModel()
    {

    }
}