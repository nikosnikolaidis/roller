<%@ include file="/taglibs.jsp" %><%
RollerContext rctx = RollerContext.getRollerContext(request);
RollerSession rollerSession = RollerSession.getRollerSession(request);
UserData user = rollerSession.getAuthenticatedUser();
WebsiteData website = rollerSession.getCurrentWebsite();
String absURL = rctx.getAbsoluteContextUrl(request);
boolean allowNewUsers = RollerConfig.getBooleanProperty("users.registration.enabled");
%>
<div class="bannerBox">
   <img src="<%= request.getContextPath() %>/theme/images/two-bigbadge.png" 
      style="padding: 15px 0px 0px 15px;"/>
</div>

<div class="statusBox">
    
    <div class="bannerLeft">
        <% if (user != null) { %>
            <fmt:message key="mainPage.loggedInAs" />:
             [<b><%= user.getUserName() %></b>]
        <% } %>
    </div>

    <div class="bannerRight">
        <roller:link forward="main">
            <fmt:message key="mainPage.frontPage" />
        </roller:link>
        | <roller:link forward="yourWebsites">
            <fmt:message key="mainPage.mainMenu" />
        </roller:link>
        <% if (user != null) { %>
            | <html:link forward="logout-redirect"><fmt:message key="navigationBar.logout"/></html:link>
        <% } else if (allowNewUsers) { %>
            | <html:link forward="login-redirect"><fmt:message key="navigationBar.login"/></html:link>
            | <html:link forward="registerUser"><fmt:message key="navigationBar.register"/></html:link>
        <% } else { %>
            | <html:link forward="login-redirect"><fmt:message key="navigationBar.login"/></html:link>
        <% } %>

    </div>
    
</div>



