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
                        <form id="user-reg-form" action="" method="POST">
                            <%-- FirstName --%>
                            <div class="mb-3 form-group">
                                <label for="user-first-name" class="form-label">FirstName</label>
                                <input type="text" name="firstname" class="form-control" id="user-first-name"
                                       aria-describedby="emailHelp" placeholder="FirstName" required>
                            </div>

                            <%-- LastName --%>
                            <div class="mb-3 form-group">
                                <label for="user-last-name" class="form-label">LastName</label>
                                <input type="text" name="lastname" class="form-control" id="user-last-name"
                                       aria-describedby="emailHelp" placeholder="LastName" required>
                            </div>

                            <%-- email --%>
                            <div class="mb-3 form-group">
                                <label for="user-email" class="form-label">Email address</label>
                                <input type="email" name="email" class="form-control" id="user-email"
                                       aria-describedby="emailHelp" placeholder="Enter email" required>
                                <div id="emailHelp" class="form-text">We'll never share your email with anyone
                                    else.
                                </div>
                            </div>

                            <%-- phoneNumber --%>
                            <div class="mb-3 form-group">
                                <label for="user-phone" class="form-label">Phone Number</label>
                                <input type="number" name="phone" class="form-control" id="user-phone"
                                       aria-describedby="phoneHelp" placeholder="Enter phone number">
                                <div id="phoneHelp" class="form-text">(optional)</div>
                            </div>

                            <%-- password --%>
                            <div class="mb-3 form-group">
                                <label for="user-password" class="form-label">Password</label>
                                <input type="password" name="password" class="form-control" id="user-password"
                                       aria-describedby="passwordHelp"
                                       placeholder="Password" required>
                                <div id="passwordHelp" class="form-text">password must contain at least one symbol and
                                    digit
                                </div>
                            </div>

                            <%-- gender--%>
                            <div class="mb-3 form-group">
                                <label class="form-label">Select Gender</label>
                                <br>
                                <input type="radio" id="gender-m" value="male" name="gender" required> Male
                                <input type="radio" id="gender-f" value="female" name="gender" required> Female
                            </div>

                            <%-- about --%>
                            <div class="mb-3 form-group">
                                <label for="user-about" class="form-label">About</label>
                                <textarea class="form-control" name="about" id="user-about" rows="5"
                                          placeholder="Enter something that makes you special"
                                          aria-describedby="aboutHelp">
                                 </textarea>
                                <div id="aboutHelp" class="form-text">(optional)</div>
                            </div>

                            <%-- terms and condition --%>
                            <div class="mb-3 form-check">
                                <input type="checkbox" name="check" class="form-check-input" id="user_accept_tandc"
                                       required>
                                <label class="form-check-label" for="user_accept_tandc">Agree terms and
                                    conditions</label>
                            </div>
                            <br>
                            <%-- submit --%>
                            <div id="loader" class="container text-center" style="display: none">
                                <span class="fa fa-spinner fa-spin fa-2x"></span>
                                <p>Please Wait...</p>
                            </div>
                            <br>
                            <button id="btn-submit" type="submit" class="btn btn-primary">Submit</button>
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
<%-- for animated alerts --%>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script>
    <%-- Ajax --%>
    $(document).ready(() => {
        // console.log("Loaded ........")
        $("#user-reg-form").on("submit", (event) => {
            event.preventDefault();
            let form = new FormData(event.target);
            $("#btn-submit").hide();
            $("#loader").show();
            // send register servlet
            $.ajax({
                url: "register",
                type: "POST",
                data: form,
                success: (data, textStatus, jqXHR) => {
                    $("#loader").hide();
                    $("#btn-submit").show();
                    Swal.fire({
                        icon: "success",
                        title: "Success",
                        text: data,
                    }).then((value)=>{
                        let timerInterval;
                        // run for 3000 millisecond, update the text each 100 millisecond
                        Swal.fire({
                            title: "Redirecting in 3 seconds...",
                            timer: 3000,
                            timerProgressBar: true,
                            didOpen: () => {
                                Swal.showLoading();
                                timerInterval = setInterval(() => {
                                }, 100);
                            },
                        }).then(()=>{window.location = "login.jsp"});
                    });
                },
                error: (data, textStatus, errorThrown) => {
                    $("#loader").hide();
                    $("#btn-submit").show();
                    Swal.fire({
                        icon: "error",
                        title: "Error",
                        text: data.responseText,
                    });
                },
                processData: false,
                contentType: false
            })
        });
    });
</script>
</body>
</html>
