<%@ include file="header.jsp"%>

<table class="table table-bordered">
	<thead>
		<tr>
			<th align="left" width="90">Song</th>
			<th align="left" width="90">Artist</th>
			<th align="left" width="90">Album</th>
			<th align="left" width="90">Quantity</th>
			<th align="left" width="90">Unit Price</th>
			<th align="left" width="90">Category</th>
			<th align="left" width="90">Total Value</th>

			<th align="left" width="90"></th>
			<th align="left" width="90"></th>
		</tr>
	</thead>
	<c:if test="${!empty songs}">
		<c:forEach items="${songs}" var="song">
			<tr>
				<td>${song.name}</td>
				<td>${song.artist}</td>
				<td>${song.album}</td>
				<td>${song.quantityInStock}</td>
				<td>${song.unitPrice}</td>
				<td>${song.category}</td>
				<td>${song.unitPrice * song.quantityInStock}</td>

				<td><a href="<c:url value='/editSong/${song.id}' />">Edit</a></td>
				<td><a href="<c:url value='/removeSong/${song.id}' />">Delete</a></td>
			</tr>
		</c:forEach>
	</c:if>
</table>
</div>

<%@ include file="footer.jsp"%>