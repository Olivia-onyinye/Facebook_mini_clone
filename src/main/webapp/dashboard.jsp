<%--
  Created by IntelliJ IDEA.
  User: deca
  Date: 03/11/2022
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Facebook Clone</title>
  <style> <%@ include file="css/postStyle.css"%> </style>
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"/>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<!-- header starts -->
<div class="header">
  <div class="header__left">
    <img
            src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/Facebook_f_logo_%282019%29.svg/1200px-Facebook_f_logo_%282019%29.svg.png"
            alt=""
    />
    <div class="header__input">
      <span class="material-icons"> search </span>
      <input type="text" placeholder="Search Facebook" />
    </div>
  </div>

  <div class="header__middle">
    <div class="header__option active">
      <span class="material-icons"> home </span>
    </div>
    <div class="header__option">
      <span class="material-icons"> flag </span>
    </div>
    <div class="header__option">
      <span class="material-icons"> subscriptions </span>
    </div>
    <div class="header__option">
      <span class="material-icons"> storefront </span>
    </div>
    <div class="header__option">
      <span class="material-icons"> supervised_user_circle </span>
    </div>
  </div>

  <div class="header__right">
    <div class="header__info">

      <h4><c:out value="${sessionScope.loggedUser.userName }"/></h4>

    </div>
    <a href ="loginPage.jsp"><span class="material-icons">logout</span></a>
  </div>
</div>
<!-- header ends -->

<!-- main body starts -->
<div class="main__body">
  <!-- sidebar starts -->
  <div class="sidebar">
    <div class="sidebarRow">

      <h4><c:out value="${sessionScope.loggedUser.userName }"/></h4>
    </div>

    <div class="sidebarRow">
      <span class="material-icons"> local_hospital </span>
      <h4>Medics</h4>
    </div>

    <div class="sidebarRow">
      <span class="material-icons"> emoji_flags </span>
      <h4>Pages</h4>
    </div>

    <div class="sidebarRow">
      <span class="material-icons"> people </span>
      <h4>People</h4>
    </div>

    <div class="sidebarRow">
      <span class="material-icons"> chat </span>
      <h4>Messenger</h4>
    </div>

    <div class="sidebarRow">
      <span class="material-icons"> storefront </span>
      <h4>Marketplace</h4>
    </div>

    <div class="sidebarRow">
      <span class="material-icons"> video_library </span>
      <h4>Videos</h4>
    </div>

    <div class="sidebarRow">
      <span class="material-icons"><a href ="#" > expand_more</a> </span>
      <h4>More</h4>
    </div>
  </div>
  <!-- sidebar ends -->

  <!-- feed starts -->
  <div class="feed">
    <div class="storyReel">
      <!-- story starts -->
      <div
              style="
              background-image: url('https://images.unsplash.com/photo-1527082395-e939b847da0d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80');
            "
              class="story"
      >


      </div>
      <!-- story ends -->

      <!-- story starts -->
      <div
              style="
              background-image: url('https://cellularnews.com/wp-content/uploads/2020/04/Delete-photo-337x600.jpg');
            "
              class="story"
      >


      </div>
      <!-- story ends -->

      <!-- story starts -->
      <div style="
              background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTBHC2s4NFdzXEsVzvBPGjkrSePQa-8XFuNtQ&usqp=CAU');
            " class="story">


      </div>
      <!-- story ends -->

      <!-- story starts -->
      <div
              style="
              background-image: url('https://images.unsplash.com/photo-1527082395-e939b847da0d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80');
            "
              class="story"
      >

      </div>
      <!-- story ends -->

      <!-- story starts -->
      <div
              style="
              background-image: url('https://cellularnews.com/wp-content/uploads/2020/04/Delete-photo-337x600.jpg');
            "
              class="story"
      >


      </div>
      <!-- story ends -->

      <!-- story starts -->
      <div
              style="
              background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTBHC2s4NFdzXEsVzvBPGjkrSePQa-8XFuNtQ&usqp=CAU');
            "
              class="story"
      >

      </div>
      <!-- story ends -->
    </div>

    <!-- message sender starts -->
    <div class="messageSender">
      <div class="messageSender__top">
<%--        <input type="hidden" name="user_id" value=${sessionScope.loggedUser.getUserName()}>--%>
        <form action="newPost" method="post" >
          <textarea style="overflow: auto;
                               height: auto;
                               display:block;
                               border-radius: 7px;
                               border: 2px solid lightskyblue"
                    name="text_body" class="messageSender__input" placeholder="What's on your mind?"></textarea>
          <div class="messageSender__option">
            <button type="submit" style="margin-top: 20px;">Post</button>
          </div>
        </form>
              </div>
                  <div class="messageSender__bottom">
                      <div class="messageSender__option">
                          <span style="color: red" class="material-icons"> videocam </span>
                          <h3>Live</h3>
                      </div>
                      <div class="messageSender__option">
                          <span style="color: green" class="material-icons"> photo_library </span>
                          <h3>Photo</h3>
                      </div>
                  </div>
    </div>
    <!-- message sender ends -->

    <!-- post starts -->
<div class="poster">
    <c:forEach var="post2" items="${posts}">
      <br><br>
        <div class="container mt-5">
          <div class="d-flex justify-content-center row">
            <div class="col-md-8">
              <div class="d-flex flex-column comment-section">
                <div class="bg-white p-2">
                  <div class="d-flex flex-row user-info">
                    <img class="rounded-circle" src="https://i.imgur.com/RpzrMR2.jpg" width="40">
                    <div class="d-flex flex-column justify-content-start ml-2">
                      <span class="d-block font-weight-bold name">${post2.getUserName()}</span>
                      <span class="date text-black-50">Shared publicly - Jan 2020</span></div>
                  </div>
                  <div class="mt-2">
                    <p class="comment-text"> ${post2.getText_body()}</p>
                  </div>
                </div>
                <div class="bg-white">
                  <div class="d-flex flex-row fs-12">
                    <div class="like p-2 cursor">
                      <a href="${pageContext.request.contextPath}/likes/?post_id=${post2.getPost_id()}">
                        <i class="fa fa-thumbs-o-up"></i><span class="ml-1">Like</span></a>
                    </div>
                    <div class="like p-2 cursor">
                      <a href="${pageContext.request.contextPath}/edit/?post_id=${post2.getPost_id()}">
                        <i class="fa fa-commenting-o"></i><span class="ml-1">Edit</span></a>
                    </div>
                    <div class="like p-2 cursor">
                      <a href="${pageContext.request.contextPath}/delete/?post_id=${post2.getPost_id()}">
                        <i class="fa fa-share"></i><span class="ml-1">Delete</span></a>
                    </div>
                  </div>
                </div>
                <div class="bg-light p-2">
                  <div class="d-flex flex-row align-items-start">
                    <img class="rounded-circle" src="https://i.imgur.com/RpzrMR2.jpg" width="40">
                    <textarea class="form-control ml-1 shadow-none textarea"></textarea>
                  </div>
                  <div class="mt-2 text-right">
                    <a href="${pageContext.request.contextPath}/comment/?post_id=${post2.getPost_id()}"></a>
                    <button class="btn btn-primary btn-sm shadow-none" type="button">Post comment</button></a>
                    <button class="btn btn-outline-primary btn-sm ml-1 shadow-none" type="button">Cancel</button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

      </c:forEach>
</div>
    <!-- post ends -->

  <!-- feed ends -->

  <div style="flex: 0.33" class="widgets">
    <div
            class="fb-page"
            data-href="https://www.facebook.com/facebook"
            data-tabs="timeline"
            data-width="500"
            data-height="1000"
            data-small-header="false"
            data-adapt-container-width="true"
            data-hide-cover="false"
            data-show-facepile="true"
    >

      </blockquote>
    </div>
  </div>
</div>
<!-- main body ends -->

<div id="fb-root"></div>
<%--<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"--%>
<%--        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"--%>
<%--        crossorigin="anonymous"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"--%>
<%--        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"--%>
<%--        crossorigin="anonymous"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"--%>
<%--        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"--%>
<%--        crossorigin="anonymous"></script>--%>
<%--<!-- <script--%>
</html>