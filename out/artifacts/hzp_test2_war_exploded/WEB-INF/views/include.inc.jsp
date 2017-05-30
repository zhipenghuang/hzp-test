<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
    String basePath = request.getContextPath();
%>
<c:set var="basePath" value="${basePath }"/>
<script type="text/javascript">
    var url = '<%=basePath%>';
</script>