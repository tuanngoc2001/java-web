<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 6/16/2022
  Time: 9:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Nhóm 2-Blog</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
    <style>
        @import url(https://unpkg.com/@webpixels/css/dist/index.css);
    </style>
    <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        html, body, h1, h2, h3, h4, h5 {font-family: "Open Sans", sans-serif}
    </style>
</head>
<body class="w3-theme-l5">

<!-- Navbar -->
<div class="w3-top">
    <div class="w3-bar w3-theme-d2 w3-left-align w3-large">
        <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-theme-d2" href="javascript:void(0);" onclick="openNav()"><i class="fa fa-bars"></i></a>
        <a href="#" class="w3-bar-item w3-button w3-padding-large w3-theme-d4"><i class="fa fa-home w3-margin-right"></i>Logo</a>
        <a href="#" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" title="News"><i class="fa fa-globe"></i></a>
        <a href="#" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" title="Account Settings"><i class="fa fa-user"></i></a>
        <a href="#" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white" title="Messages"><i class="fa fa-envelope"></i></a>
        <div class="w3-dropdown-hover w3-hide-small">
            <button class="w3-button w3-padding-large" title="Notifications"><i class="fa-solid fa-bars"></i><span class="w3-badge w3-right w3-small w3-green">3</span></button>
            <div class="w3-dropdown-content w3-card-4 w3-bar-block" style="width:300px">
                <a href="/user?action=listuser" class="w3-bar-item w3-button">Danh sách ngưởi dùng</a>
                <a href="#" class="w3-bar-item w3-button">Đăng xuất</a>
                <%--            <a href="#" class="w3-bar-item w3-button">Jane likes your post</a>--%>
            </div>

        </div>

        <a href="/user?action=login" class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large w3-hover-white" title="My Account">
            <img src="https://haycafe.vn/wp-content/uploads/2021/11/Anh-avatar-dep-chat-lam-hinh-dai-dien.jpg" class="w3-circle" style="height:23px;width:23px" alt="Avatar">
        </a>
    </div>
</div>
<!-- Banner -->
<div class="p-10 bg-surface-secondary">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <h6>Bootstrap 5 Table</h6>

            </div>
            <div class="table-responsive">
                <table class="table table-hover table-nowrap">
                    <thead class="table-light">
                    <tr>
                        <th scope="col">Username</th>
                        <th scope="col">Date</th>
                        <th scope="col">Avatar</th>
                        <th scope="col">Name</th>
                        <th scope="col">Status</th>
                        <th scope="col">Act</th>
                        <th scope="col">Edit</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items='${requestScope["users"]}' var="users">
                    <tr>
                        <td data-label="Job Title">
                             <span>${users.getUsername()}</span>
<%--                            <a class="text-heading font-semibold" href="#">--%>
<%--                                ${users.getUsername()}--%>
<%--                            </a>--%>
                        </td>
                        <td data-label="Email">
                            <span>${users.getDate()}</span>
                        </td>
                        <td data-label="Phone">
                            <img style="width: 3rem;height: 3rem" src="data:image/jpeg;base64,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">
                            <a class="text-current" href="mailto:robert.fox@example.com">${users.getEmail()}</a>
                        </td>
                        <td data-label="Lead Score">
                            <a class="text-current" href="tel:202-555-0152">${users.getName()}</a>
                        </td>
                        <td data-label="Company">
                            <span class="badge bg-soft-success text-success">${users.isStatus()}</span>
                        </td>
                        <td data-label="">
                            <a class="text-current" href="#">${users.isAct()}</a>
                        </td>
                        <td data-label="">
                            <a class="text-current" href="/user?action=edit&id=${users.getId()}">Edit</a>
                        </td>
                        <td data-label="" class="text-end">
                            <div class="dropdown">
                                <a class="text-muted" href="#" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="bi bi-three-dots-vertical"></i>
                                </a>
                                <div class="dropdown-menu dropdown-menu-end">
                                    <a href="#!" class="dropdown-item">
                                        Action
                                    </a>
                                    <a href="#!" class="dropdown-item">
                                        Another action
                                    </a>
                                    <a href="#!" class="dropdown-item">
                                        Something else here
                                    </a>
                                </div>
                            </div>
                        </td>
                    </tr>
                    </c:forEach>
                    
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

</body>
</html>
