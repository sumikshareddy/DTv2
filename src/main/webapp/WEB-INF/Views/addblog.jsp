<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular.min.js"></script>
<title>addblog</title>
</head>
<style>
@blue: #79B9D2;
@accent: darken(@blue,20);

* {
  box-sizing:border-box;
}

html {
  font-size:18px;
}

.topbar {
  background:@blue;
  color:white;
  width:100%;
  z-index:9999;
  padding:5px 20px;
  
  h1 {
    cursor:pointer;
  }
  
  nav {
    margin-top:25px;
    
    ul {
      padding:0;
      margin:0;
      
      li {
        display:inline-block;
        padding:10px;
        
        a {
          color:white;
          text-decoration:none;
        }
      }
    }
  }
}


  
  ul.post-grid {
    margin:0;
    padding:0;
    list-style-type:none;
    
    li {
      padding:20px;
      cursor:pointer;
      transition: background linear 0.5s;
      border-bottom:1px solid @accent;
      
      &:hover {
      background:@accent;
      color:white;
      
        h3 {
          color: white;
        }
       
      }
    }
  }


.content {
  width:100%;
  position:relative;
  padding:20px 40px 20px;
}

 h2, h3 {
    color: @accent;
  }

.post {
  -webkit-transition:0.5s linear all;
  transition:0.5s linear all;
  opacity:1;
  padding-bottom:30px;
  
  cite {
    display:inline-block;
    padding:10px 0;
  }
}

.comments {
  ul {
    margin:0;
    padding:0;
    li {
      list-style-type:none;
      padding:20px 5px;
      border-bottom:1px @blue solid;
    }
  }
}

.post.ng-hide {
  opacity:0;
}

.post.ng-hide-add, .post.ng-hide-remove {
  display:block!important;
}

form {
  width:100%;
}
input, textarea {
  display:block;
  width:100%;
  padding:10px;
  font-size:1.1em;
}

.ng-invalid.ng-dirty {
  border-color:red;
}

.ng-valid.ng-dirty {
  border-color:green;
}

img {
  max-width:100%;
}
</style>

<body ng-app="blogApp">
  
  <div ng-controller="BlogController as resource">
      <div class="topbar">
        <div class="container">
          <div class="row">
            <div class="col-s-4">
              <h1 ng-click="blog.selectTab('blog')" class="push-left">{{resource.title}}</h1>
            </div>
            <div class="offset-s-4 col-s-4">
              <nav role='navigation' class="push-right">
                <ul>
                  <li><a href="viewblog" ng-click="blog.selectTab('blog')">See All Posts</a></li> 
                  <li><a href="blog" ng-click="blog.selectTab('new')">Add New Post</a></li>
                </ul>
              </nav> 
            </div>
          </div>
        </div>
        
        
         
      </div>
     
      
      <div class="content">
        <div class="container">
          <div class="row">
            <ul class="post-grid" ng-show="blog.isSelected('blog')">
          <li ng-repeat="resource in names  class="col-s-4" ng-class="{ 'reset-s' : $index%3==0 }" ng-click="blog.selectTab($index)" >
            <h3>{{resource.title}}</h3>
            <p>{{post.body[0] | limitTo:70}}...</p>
           
          </li>
        </ul>
        <div class="post" ng-repeat="resource in names  ng-show="blog.isSelected($index)">
          <div>
            
            <h2>{{resource.title}}</h2>
            <img src="{{post.image}}" ng-show="{{post.image}}"/>
            <cite>by {{resource.user.uid}} on {{post.createdOn | date}}</cite>
            <div class="post-body">
             <p ng-repeat="content in post.body">
               {{content}}
             </p> 
            </div>
            
            <div class="comments" ng-controller="CommentController as commentCtrl">
             <!--  <button class="fa fa-heart" ng-click="post.likes = post.likes+1"> {{post.likes}}</button>
 -->              <h3>Comments</h3>
              <ul>
               <li ng-repeat="comment in post.comments">
                 "{{comment.comid}}"
                 <cite>- <b>{{comment.cdesc}}</b></cite>
               </li>
              </ul>
              <form name="commentForm" ng-submit="commentForm.$valid && commentCtrl.addComment(post)" novalidate>
              
                
                <h4>Add Comment</h4>
                  <textarea ng-model="commentCtrl.comment.body" cols="30" rows="10" required></textarea>
                <label for="">by:</label>
                  <input type="text" ng-model="commentCtrl.Comment.author" required placeholder="Name"/>
                  
                  <input type="submit" value="Submit" />
                </form>
            </div>
        </div>
      </div>
        <div class="post" ng-show="blog.isSelected('new')">
          <h2>Add New Post</h2>
          
          <form name="postForm" ng-submit=" blog.addPost()" novalidate>
                  <h4>Title</h4>
                  <input type="text" ng-model="blog.post.title"/>
                  <h4>Body</h4>
                  <textarea ng-model="blog.post.body" ng-list="/\n/" rows="10"></textarea>
                  <label for="">Featured Image URL</label>
                  <input type="text" ng-model="blog.post.image" placeholder="http://placekitten.com/g/2000/600" />
                  <label for="">by:</label>
                  <input type="text" ng-model="blog.post.author" placeholder="Author Name" required/>
                  
                  <input type="submit" value="Submit" />
                </select></form>
          
            </div>
            
          </div>
        </div>
        
    </div>
  </div>
  
  
</body> 
 <script>
/*

Simple blog front end demo in order to learn AngularJS - You can add new posts, add comments, and like posts.

*/

(function(){
  var app = angular.module('blogApp',[]);
  
  app.controller('BlogController', ['$http', function($http){
    
    var blog = this;
    blog.title = "AngularJS Blog App";
    
    blog.posts = {};
    $http.get('https://s3-us-west-2.amazonaws.com/s.cdpn.io/110131/posts_1.json').success(function(data){
      blog.posts = data;
    });
    
    blog.tab = 'blog';
    
    blog.selectTab = function(setTab){
      blog.tab = setTab;
      console.log(blog.tab)
    };
    
    blog.isSelected = function(checkTab){
      return blog.tab === checkTab;
    };
    
    blog.post = {};
    blog.addPost = function(){
      blog.post.createdOn = Date.now();
      blog.post.comments = [];
      blog.post.likes = 0;
      blog.posts.unshift(this.post);
      blog.tab = 0;
      blog.post ={};
    };   
    
  }]);
  
  app.controller('CommentController', function(){
    this.comment = {};
    this.addComment = function(post){
      this.comment.createdOn = Date.now();
      post.comments.push(this.comment);
      this.comment ={};
    };
  });
 
})();
</script>
  
</body>
</html>