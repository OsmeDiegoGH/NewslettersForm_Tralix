<%@page contentType="text/html; charset=UTF-8" %>

<%@taglib prefix="template-engine" uri="http://kwonnam.pe.kr/jsp/template-inheritance"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<template-engine:extends name="/modules/base/baseHTMLFrame.jsp">
   <template-engine:put block="styles" type="REPLACE">
        <link href="<c:url value='/resources/libs/css/modalForm.css'/>" rel="stylesheet" tpye="text/css">
        <link href="<c:url value='/resources/modules/css/newslettersForm.css'/>" rel="stylesheet" tpye="text/css">
    </template-engine:put>
    <template-engine:put block="content" type="REPLACE">
        <div class="col-xs-12 col-md-8 col-md-offset-2">
            <newsletters-form></newsletters-form>
        </div>
    </template-engine:put>
    <template-engine:put block="scripts" type="REPLACE">
        <script src="<c:url value='/resources/libs/js/modalForm.min.js'/>"></script>
        <script src="<c:url value='/resources/libs/js/rest.min.js'/>"></script>
        <script src="<c:url value='/resources/libs/js/messages.min.js'/>"></script>
        <script src="<c:url value='/resources/modules/js/newslettersForm.min.js'/>"></script>        
        <script type="text/javascript">
            (function(document){
                angular.module("newslettersFormModule").constant("URL_RESOURCES", "<c:url value='/resources/'/>");
                angular.module("newslettersFormModule").constant("mexicoStates", [
                    {Id:1, Name:"Estado 1"},
                    {Id:2, Name:"Estado 2"},
                    {Id:3, Name:"Estado 3"}
                ]);
                angular.module("newslettersFormModule").constant("industries", [
                    {Id:1, Name:"Industria 1"},
                    {Id:2, Name:"Industria 2"},
                    {Id:3, Name:"Industria 3"}
                ]);
                
                angular.bootstrap(document, ["newslettersFormModule"]);
            })(document);
        </script> 
    </template-engine:put>
</template-engine:extends>