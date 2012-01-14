<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:directive.page
    language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" />
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>${q} est-il vivant ? </title>
    <link rel="stylesheet" type="text/css" href="/stylesheets/style.css"/>
  </head>
  <body>
  <div id="main">
    <h1>${ans.title}</h1>
    <div id="answer">
        <a id="avatar" href="${ans.avatarLinkURL}" name="${ans.avatarName}"><img src="${ans.avatarImageURL}" /></a>
        <div id="description">${ans.avatarAnswer}</div>
    </div>
    <div id="seealsodiv">
        <p>Ou alors vouliez-vous parler d'une des personnes suivantes&nbsp;? </p>
        <ul class="seealso">
            <c:forEach items="${ans.similarPersonae}" var="persona">
                <li><a href="/search?q=${persona.fullName}">${persona.fullName}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div id="partners">
        <p>Chercher <a href="http://www.amazon.fr/s/field-keywords=${q}">${q} sur Amazon</a>.</p>
    </div>
  </div>
  </body>
</html>
