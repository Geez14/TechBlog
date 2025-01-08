<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.geez14.techblogs.entities.User" %>
<html>
<head>
    <%User u = (User) session.getAttribute("userSession");%>
    <title>Profile</title>
    <%-- css --%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="resources/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<%-- Nav Bar START --%>
<nav class="navbar navbar-expand-lg navbar-dark primary-background">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp"><span class="fa fa-diamond"></span> KnowledgeMD</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll"
                aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarScroll">
            <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#"><span class="fa fa-github-alt"></span>
                        Code&Whiskers</a>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        <span class="fa fa-book"></span> Categories
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">LeetCode</a></li>
                        <li><a class="dropdown-item" href="#">DSA</a></li>
                        <li><a class="dropdown-item" href="#">AI/ML</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item" href="#">News</a></li>
                    </ul>
                </li>
            </ul>
            <ul>
                <li class="nav-item">
                    <a class="nav-link active" href="#"><span class="fa fa-user-circle"></span>  <%=u.getUsername()%></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="${pageContext.request.contextPath}/logout"><span class="fa fa-exclamation-circle"></span>Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<%-- Nav Bar END --%>
</body>
</html>
