<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
        <title>Spring Boot File Upload / Download Rest API Example</title>
        <!--  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" />-->
    </head>
    <style>
    @charset "ISO-8859-1";* {
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
}

body {
    margin: 0;
    padding: 0;
    font-weight: 400;
    font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
    font-size: 1rem;
    line-height: 1.58;
    color: #333;
    background-color: #f4f4f4;
}

body:before {
    height: 50%;
    width: 100%;
    position: absolute;
    top: 0;
    left: 0;
    background: #128ff2;
    content: "";
    z-index: 0;
}

.clearfix:after {
    display: block;
    content: "";
    clear: both;
}


h1, h2, h3, h4, h5, h6 {
    margin-top: 20px;
    margin-bottom: 20px;
}

h1 {
    font-size: 1.7em;
}

a {
    color: #128ff2;
}

button {
    box-shadow: none;
    border: 1px solid transparent;
    font-size: 14px;
    outline: none;
    line-height: 100%;
    white-space: nowrap;
    vertical-align: middle;
    padding: 0.6rem 1rem;
    border-radius: 2px;
    transition: all 0.2s ease-in-out;
    cursor: pointer;
    min-height: 38px;
}

button.primary {
    background-color: #128ff2;
    box-shadow: 0 2px 2px 0 rgba(0, 0, 0, 0.12);
    color: #fff;
}

input {
    font-size: 1rem;
}

input[type="file"] {
    border: 1px solid #128ff2;
    padding: 6px;
    max-width: 100%;
}

.file-input {
    width: 100%;
}

.submit-btn {
    display: block;
    margin-top: 15px;
    min-width: 100px;
}

@media screen and (min-width: 500px) {
    .file-input {
        width: calc(100% - 115px);
    }

    .submit-btn {
        display: inline-block;
        margin-top: 0;
        margin-left: 10px;
    }
}

.upload-container {
      max-width: 700px;
      margin-left: auto;
      margin-right: auto;
      background-color: #fff;
      box-shadow: 0 1px 11px rgba(0, 0, 0, 0.27);
      margin-top: 60px;
      min-height: 400px;
      position: relative;
      padding: 20px;
}

.upload-header {
    border-bottom: 1px solid #ececec;
}

.upload-header h2 {
    font-weight: 500;
}

.single-upload {
    padding-bottom: 20px;
    margin-bottom: 20px;
    border-bottom: 1px solid #e8e8e8;
}

.upload-response {
    overflow-x: hidden;
    word-break: break-all;
}
    </style>
    <body>
        <noscript>
            <h2>Sorry! Your browser doesn't support Javascript</h2>
        </noscript>
        <div class="upload-container">
            <div class="upload-header">
                <h2>Spring Boot File Upload / Download Rest API Example</h2>
            </div>
            <div class="upload-content">
                <div class="single-upload">
                    <h3>Upload Single File</h3>
                    <form id="singleUploadForm" name="singleUploadForm" action="/uploadFile/${org}/${role}" method="post" enctype="multipart/form-data">
                    <input  type="number" name="stuid" placeholder="Enter Stuid" required /><br>
                     <input  type="text" name="full_name" placeholder="Enter full name" required /><br>
                      <input type="email" name="email" placeholder="Enter Email" required /><br>
                       <input  type="text" name="message" placeholder="Enter Message" required /><br>
                        <input  type="file" name="file" class="file-input" required /><br>
                        <button type="submit" class="primary submit-btn">Submit</button>
                    </form>
                    <div class="upload-response">
                        <div id="singleFileUploadError"></div>
                        <div id="singleFileUploadSuccess"></div>
                    </div>
                </div>
               
            </div>
        </div>
        <script >
        'use strict';
        var singleUploadForm = document.querySelector('#singleUploadForm');
        var singleFileUploadInput = document.querySelector('#singleFileUploadInput');
        var singleFileUploadError = document.querySelector('#singleFileUploadError');
        var singleFileUploadSuccess = document.querySelector('#singleFileUploadSuccess');

        var multipleUploadForm = document.querySelector('#multipleUploadForm');
        var multipleFileUploadInput = document.querySelector('#multipleFileUploadInput');
        var multipleFileUploadError = document.querySelector('#multipleFileUploadError');
        var multipleFileUploadSuccess = document.querySelector('#multipleFileUploadSuccess');

        function uploadSingleFile(file) {
            var formData = new FormData();
            formData.append("file", file);

            var xhr = new XMLHttpRequest();
            xhr.open("POST", "/uploadFile");

            xhr.onload = function() {
                console.log(xhr.responseText);
                var response = JSON.parse(xhr.responseText);
                if(xhr.status == 200) {
                    singleFileUploadError.style.display = "none";
                    singleFileUploadSuccess.innerHTML = "<p>File Uploaded Successfully.</p><p>DownloadUrl : <a href='" + response.fileDownloadUri + "' target='_blank'>" + response.fileDownloadUri + "</a></p>";
                    singleFileUploadSuccess.style.display = "block";
                } else {
                    singleFileUploadSuccess.style.display = "none";
                    singleFileUploadError.innerHTML = (response && response.message) || "Some Error Occurred";
                }
            }

            xhr.send(formData);
        }

        function uploadMultipleFiles(files) {
            var formData = new FormData();
            for(var index = 0; index < files.length; index++) {
                formData.append("files", files[index]);
            }

            var xhr = new XMLHttpRequest();
            xhr.open("POST", "/uploadMultipleFiles");

            xhr.onload = function() {
                console.log(xhr.responseText);
                var response = JSON.parse(xhr.responseText);
                if(xhr.status == 200) {
                    multipleFileUploadError.style.display = "none";
                    var content = "<p>All Files Uploaded Successfully</p>";
                    for(var i = 0; i < response.length; i++) {
                        content += "<p>DownloadUrl : <a href='" + response[i].fileDownloadUri + "' target='_blank'>" + response[i].fileDownloadUri + "</a></p>";
                    }
                    multipleFileUploadSuccess.innerHTML = content;
                    multipleFileUploadSuccess.style.display = "block";
                } else {
                    multipleFileUploadSuccess.style.display = "none";
                    multipleFileUploadError.innerHTML = (response && response.message) || "Some Error Occurred";
                }
            }

            xhr.send(formData);
        }


        singleUploadForm.addEventListener('submit', function(event){
            var files = singleFileUploadInput.files;
            if(files.length === 0) {
                singleFileUploadError.innerHTML = "Please select a file";
                singleFileUploadError.style.display = "block";
            }
            uploadSingleFile(files[0]);
            event.preventDefault();
        }, true);


        multipleUploadForm.addEventListener('submit', function(event){
            var files = multipleFileUploadInput.files;
            if(files.length === 0) {
                multipleFileUploadError.innerHTML = "Please select at least one file";
                multipleFileUploadError.style.display = "block";
            }
            uploadMultipleFiles(files);
            event.preventDefault();
        }, true);
        </script>
    </body>
</html>