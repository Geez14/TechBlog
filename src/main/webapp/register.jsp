<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Register</title>
    <%-- css --%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="resources/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<%-- navbar --%>
<%@ include file="WEB-INF/components/nav-bar.jsp" %>
<%-- form-control --%>
<main class="d-flex align-items-center primary-background banner-background p-5" style="padding-bottom: 50px">
    <div class="container">
        <%-- This row can contain 12 columns --%>
        <div class="row">
            <%-- column occupy 4 column space where we give offset of 4 column --%>
            <div class="col-md-6 offset-md-3" style="min-width: 300px">
                <div class="card">
                    <div class="card-header primary-background text-white">
                        <div style="width: 100%;text-align: center">
                            <span class="fa fa-user-plus fa-3x"></span>
                            <br/>
                            <p>Register</p>
                        </div>
                    </div>
                    <div class="card-body">
                        <form action="register" method="POST">
                            <%-- FirstName --%>
                            <div class="mb-3 form-group">
                                <label for="user_first_name" class="form-label">FirstName</label>
                                <input type="text" name="firstname" class="form-control" id="user_first_name"
                                       aria-describedby="emailHelp" placeholder="FirstName">
                            </div>

                             <%-- LastName --%>
                            <div class="mb-3 form-group">
                                <label for="user_last_name" class="form-label">LastName</label>
                                <input type="text" name="lastname" class="form-control" id="user_last_name"
                                       aria-describedby="emailHelp" placeholder="LastName">
                            </div>

                            <%-- email --%>
                            <div class="mb-3 form-group">
                                <label for="user_email" class="form-label">Email address</label>
                                <input type="email" name="email" class="form-control" id="user_email"
                                       aria-describedby="emailHelp" placeholder="Enter email">
                                <div id="emailHelp" class="form-text">We'll never share your email with anyone
                                    else.
                                </div>
                            </div>

                            <%-- phoneNumber --%>
                            <div class="mb-3 form-group">
                                <label for="user_phone" class="form-label">Phone Number</label>
                                <input type="number" name="phone" class="form-control" id="user_phone"
                                       aria-describedby="emailHelp" placeholder="Enter phone number">
                                <div id="phoneHelp" class="form-text">We'll never share your phone number with any one
                                </div>
                            </div>

                             <%-- password --%>
                            <div class="mb-3 form-group">
                                <label for="exampleInputPassword1" class="form-label">Password</label>
                                <input type="password" name="password" class="form-control" id="exampleInputPassword1"
                                       placeholder="Password">
                            </div>

                             <%-- gender--%>
                            <div class="mb-3 form-group">
                                <label class="form-label">Select Gender</label>
                                <br>
                                <input type="radio" id="genderM" value="male" name="gender"> Male
                                <input type="radio" id="genderF" value="female" name="gender"> Female
                            </div>

                             <%-- about --%>
                            <div class="mb-3 form-group">
                                <label for="user_about" class="form-label"></label>
                                <textarea class="form-control" name="about" id="user_about" rows="5"
                                          placeholder="Enter something that makes you special">
                                 </textarea>
                            </div>

                             <%-- terms and condition --%>
                            <div class="mb-3 form-check">
                                <input type="checkbox" name="check" class="form-check-input" id="exampleCheck1">
                                <label class="form-check-label" for="exampleCheck1">Agree terms and conditions</label>
                            </div>
                            <br>
                             <%-- submit --%>
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
<%-- javascript --%>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
        integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
        integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
        crossorigin="anonymous"></script>
<script src="resources/js/main.js"></script>
</body>
</html>
