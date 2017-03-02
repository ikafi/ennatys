<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fi">
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="/favicon.ico">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Ikariam ennätys - Zeta</title>
    <meta name="description" content="Ikariamin Suomen uusimman serverin Zetan ennätykset täältä vuorokauden ympäri! Seuraa parhaiden pelaajien karkaamista horisonttiin tai ilmoita omat ennätyksesi muiden nähtäville.">
    <link rel="canonical" href="https://zeta.gosu.fi/">

    <meta property="og:site_name" content="Ikariam ennätys - Zeta">
    <meta property="og:type" content="website">
    <meta property="og:title" content="Ikariam ennätys - Zeta">
    <meta property="og:description" content="Ikariamin Suomen uusimman serverin Zetan ennätykset täältä vuorokauden ympäri! Seuraa parhaiden pelaajien karkaamista horisonttiin tai ilmoita omat ennätyksesi muiden nähtäville.">
    <meta property="og:url" content="https://zeta.gosu.fi/">

    <meta name="twitter:card" content="summary">
    <meta name="twitter:title" content="Ikariam ennätys - Zeta">
    <meta name="twitter:description" content="Ikariamin suomenSuusimman serverin Zetan ennätykset täältä vuorokauden ympäri! Seuraa parhaiden pelaajien karkaamista horisonttiin tai ilmoita omat ennätyksesi muiden nähtäville.">
    <meta name="twitter:url" content="https://zeta.gosu.fi/">

    <script async="" src="//www.google-analytics.com/analytics.js"></script><script type="application/ld+json">
    {
      "@context": "http://schema.org",
      "@type": "Website",
      "publisher": "Ikariam ennätys - Zeta",
      "url": "https://zeta.gosu.fi/",
      "description": "Ikariamin suomen uusimman serverin zetan ennätykset täältä vuorokauden ympäri! Seuraa parhaiden pelaajien karkaamista horisonttiin tai ilmoita omat ennätyksesi muiden nähtäville."
    }
    </script>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <script type="text/javascript" charset="UTF-8" src="<c:url value='/resources/jquery-2.1.1.min.js' />"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script type="text/javascript" charset="UTF-8" src="<c:url value='/resources/index.js' />"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/index.css' />" />

    <script>
        (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
                (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
            m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
        })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');
        ga('create', 'UA-58417001-7', 'auto');
        ga('send', 'pageview');
    </script>
    <script>
        var success = '${success}';
        var error = '${error}';
    </script>

</head>
<body>
<div class="container">
    <center>
        <img src="/resources/logo.png" />
        <h1>ZETA - HALL OF FAME</h1>
        <c:if test="${not empty success}">
            <div class="alert alert-success">
                    ${success}
            </div>
        </c:if>
        <c:if test="${not empty error}">
            <div class="alert alert-danger">
                    ${error}
            </div>
        </c:if>
        <c:forEach items="${categories}" var="category">
            <div class="category">
                <div class="title">${fn:toUpperCase(category.name)}</div>
                <table>
                    <c:forEach items="${category.records}" var="record">
                        <tr onclick="update(this, ${record.id}, '${record.name}', '${record.value}', '${record.user}', '${record.date}', '${record.evidence}');">
                            <td>${record.name}</td>
                            <td class="value">${record.value}</td>
                            <td class="user">${record.user}</td>
                            <td class="date">${record.date}</td>
                            <td class="link">
                                <c:if test="${not empty record.evidence}">
                                    <a href="${record.evidence}" target="_blank"><span class="glyphicon glyphicon-new-window"></span></a>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                </table>
            </div>
        </c:forEach>
    </center>
    <div class="modal fade" id="updateModal" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Päivitä ennätys "<span id="name"></span>"</h4>
                </div>
                <div class="modal-body">
                    <form id="updateForm" action="/record" method="POST" role="form">
                        <div class="form-group">
                            <label for="value">Ennätys</label>
                            <input type="text" class="form-control" id="value" name="value" placeholder="Ennätyksen arvo (määrä yms, jätä tyhjäksi 'Ensimmäisenä..'-ennätyksille)" autocomplete="off" />
                        </div>
                        <div class="form-group">
                            <label for="user">Ennätyksen haltija</label>
                            <input type="text" class="form-control" id="user" name="user" placeholder="Ennätyksen haltija" required="required" autocomplete="off" />
                        </div>
                        <div class="form-group">
                            <label for="user">Päivämäärä</label>
                            <input type="text" class="form-control" id="date" name="date" placeholder="XX.YY.ZZZZ" required="required" autocomplete="off" />
                        </div>
                        <div class="form-group">
                            <label for="evidence">Todiste (linkki kuvaan)</label>
                            <input type="text" class="form-control" id="evidence" name="evidence" placeholder="https://todiste.fi/ennatys.png" required="required" autocomplete="off" />
                        </div>
                        <input type="hidden" id="id" name="tmpId" />
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" onclick="submitUpdateForm()">Päivitä</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Peruuta</button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
