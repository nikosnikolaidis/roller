/* * Created on Mar 4, 2004 */package org.roller.presentation;import java.io.File;import javax.servlet.ServletContext;import javax.servlet.ServletContextEvent;import javax.servlet.http.HttpServletRequest;import org.apache.commons.logging.Log;import org.apache.commons.logging.LogFactory;import org.roller.RollerException;/** * @author lance.lavandowska */public class MockRollerContext extends RollerContext{    private static Log mLogger =        LogFactory.getFactory().getInstance(MockRollerContext.class);    private static ServletContext mContext = null;    public void init(ServletContext sc)    {        mLogger.debug("MockRollerContext initializing");                // initialize super         super.contextInitialized(new ServletContextEvent(sc));                // Save context in self and self in context        mContext = sc;        mContext.setAttribute(ROLLER_CONTEXT, this);        mContext.setAttribute("org.roller.absoluteContextURL", "/");    }    //-----------------------------------------------------------------------    /** Because I cannot set the super's values, I have to     * overide the methods as well */      public static RollerContext getRollerContext(ServletContext sc)    {        // get roller from servlet context        return (RollerContext) mContext.getAttribute(ROLLER_CONTEXT);    }    //-----------------------------------------------------------------------    /** Because I cannot set the super's values, I have to     * overide the methods as well */      public static ServletContext getServletContext()    {        return mContext;    }    //-----------------------------------------------------------------------    /** Because I cannot set the super's values, I have to     * overide the methods as well */    public String getRollerVersion()    {        return super.getRollerVersion();    }    //-----------------------------------------------------------------------    /** Because I cannot set the super's values, I have to     * overide the methods as well */    public String getRollerBuildTime()    {        return super.getRollerBuildTime();    }    //-----------------------------------------------------------------------    /** Because I cannot set the super's values, I have to     * overide the methods as well */    public String getRollerBuildUser()    {        return super.getRollerBuildUser();    }    //-----------------------------------------------------------------------    /** Because I cannot set the super's values, I have to     * overide the methods as well */    public String getAbsoluteContextUrl()    {        return "";    }    //-----------------------------------------------------------------------    /** Because I cannot set the super's values, I have to     * overide the methods as well */    public String getAbsoluteContextUrl(HttpServletRequest request)    {        return request.getScheme() +"://" + request.getServerName() + "";    }    //-----------------------------------------------------------------------    /** Because I cannot set the super's values, I have to     * overide the methods as well */    /* not available anymore ... use the new config classes instead -- Allen G    public RollerConfigData getRollerConfig()    {        return super.getRollerConfig();    }    */    //------------------------------------------------------------------------    public String getConfigPath()     {        String root = System.getProperty("ro.build");        String configPath =            root                + File.separator                + "roller"                + File.separator                + "WEB-INF"                + File.separator                + "roller-config.xml";        return configPath;    }    protected void upgradeDatabaseIfNeeded() throws RollerException    {        // for now, this is a no-op    }}