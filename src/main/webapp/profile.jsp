<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.geez14.techblogs.entities.views.Profile" %>
<html>
<head>
    <%Profile p = (Profile) session.getAttribute("userSession");%>
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
            <ul class="navbar-nav mr-right">
                <li class="nav-item">
                    <a class="nav-link active" href="#" data-bs-toggle="modal" data-bs-target="#profile-modal"><span
                            class="fa fa-user-circle"></span> <%=p.getUsername().substring(0, 6)%>...
                    </a>
                </li>
                <li class="nav-item">
                    <form action="${pageContext.request.contextPath}/logout" method="post">
                        <button type="submit" class="nav-link active">
                            <span class="fa fa-power-off"></span> Logout
                        </button>
                    </form>
                </li>
            </ul>
        </div>
    </div>
</nav>
<%-- profile modal --%>
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#profile-modal">
    Launch demo modal
</button>

<!-- Modal -->
<div class="modal fade" id="profile-modal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header primary-background text-white">
                <h5 class="modal-title fs-5" id="exampleModalLabel"> User Profile </h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="container text-center">
                    <img class="img-fluid" src="${pageContext.request.contextPath}/pics/<%=p.getProfilePic()%>"
                         alt="<%=p.getProfilePic()%>" width="150px" style="padding:10px 0 20px 0">
                    <br>
                    <h5 class="modal-title fs-5" id="user-name"><%= p.getUsername()%>
                    </h5>
                    <%-- Details --%>
                    <table class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th scope="col">Key</th>
                            <th scope="col">Value</th>
                        </tr>
                        </thead>
                        <tbody class="table-group-divider">
                        <tr>
                            <th scope="row">Email</th>
                            <td><%=p.getEmail()%>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">First Name</th>
                            <td><%=p.getFirstName()%>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">Last Name</th>
                            <td><%=p.getLastName()%>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">phone-number</th>
                            <td><%=p.getPhoneNumber()%>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">Gender</th>
                            <td><%=p.getGender()%>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">Status</th>
                            <td><%=p.getAbout()%>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">Registered On</th>
                            <td><%=p.getRegistrationDate()%>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Edit</button>
                <button type="button" class="btn btn-danger text-white">Delete</button>
            </div>
        </div>
    </div>
</div>
<%-- javascript --%>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
        integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
        integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
        crossorigin="anonymous"></script>
</body>
</html>
