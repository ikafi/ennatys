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
    <meta name="description" content="Ikariam ennätys - Zeta on visailua varten sivusto, jolla saa kuvasta peitettyjä automaattisesti osia sekä luotua uniikit toisiinsa yhdistämättömät osoitteet kuville.">
    <link rel="canonical" href="https://zeta.gosu.fi/">

    <meta property="og:site_name" content="Ikariam ennätys - Zeta">
    <meta property="og:type" content="website">
    <meta property="og:title" content="Ikariam ennätys - Zeta">
    <meta property="og:description" content="Ikariam ennätys - Zeta on visailua varten sivusto, jolla saa kuvasta peitettyjä automaattisesti osia sekä luotua uniikit toisiinsa yhdistämättömät osoitteet kuville.">
    <meta property="og:url" content="https://zeta.gosu.fi/">

    <meta name="twitter:card" content="summary">
    <meta name="twitter:title" content="Ikariam ennätys - Zeta">
    <meta name="twitter:description" content="Ikariam ennätys - Zeta on visailua varten sivusto, jolla saa kuvasta peitettyjä automaattisesti osia sekä luotua uniikit toisiinsa yhdistämättömät osoitteet kuville.">
    <meta name="twitter:url" content="https://zeta.gosu.fi/">

    <script async="" src="//www.google-analytics.com/analytics.js"></script><script type="application/ld+json">
    {
      "@context": "http://schema.org",
      "@type": "Website",
      "publisher": "Ikariam ennätys - Zeta",
      "url": "https://zeta.gosu.fi/",
      "description": "Ikariam ennätys - Zeta on visailua varten sivusto, jolla saa kuvasta peitettyjä automaattisesti osia sekä luotua uniikit toisiinsa yhdistämättömät osoitteet kuville."
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

</head>
<body>
<div class="container">
    <center>
        <img src="/resources/logo.png" />
        <h1>ZETA - HALL OF FAME</h1>
        <c:forEach items="${categories}" var="category">
            <div class="category">
                <div class="title">${fn:toUpperCase(category.name)}</div>
                <table>
                    <c:forEach items="${category.records}" var="record">
                        <tr>
                            <td>${record.name}</td>
                            <td class="value">${record.value}</td>
                            <td class="user">${record.user}</td>
                            <td class="date">${record.date}</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                </table>
            </div>
        </c:forEach>
    </center>
</div>
</body>
</html>
