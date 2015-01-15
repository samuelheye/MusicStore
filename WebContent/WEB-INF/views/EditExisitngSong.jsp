<%@ include file="header.jsp"%>

<form:form role="form" method="POST" action="/MusicStore/updateSong"
	modelAttribute="song" class="form-horizontal">

	<div>

		<form:input type="hidden" class="form-control" path="id" />
		<form:errors path="id" />
		<br>
	</div>

	<div class="form-group">
		<label for="name" class="control-label col-sm-2">Song name: </label>
		<div class="col-sm-4">
			<form:input type="text" placeholder="Name" path="name"
				class="form-control" id="name" />
		</div>
		<form:errors path="name" />
	</div>




	<div class="form-group">
		<label for="artist" class="control-label col-sm-2">Artist: </label>
		<div class="col-sm-4">
			<form:input type="text" placeholder="Artist" path="artist"
				class="form-control" id="artist" />
		</div>
		<form:errors path="artist" />
	</div>


	<div class="form-group">
		<label for="album" class="control-label col-sm-2">Album: </label>
		<div class="col-sm-4">
			<form:input type="text" placeholder="Album" path="album"
				class="form-control" id="album" />
		</div>
		<form:errors path="album" />
	</div>




	<div class="form-group">
		<label for="quantityInStock" class="control-label col-sm-2">Quantity:
		</label>
		<div class="col-sm-4">
			<form:input type="text" placeholder="Quantity" path="quantityInStock"
				class="form-control" id="quantityInStock" />
		</div>
		<form:errors path="quantityInStock" />
	</div>




	<div class="form-group">
		<label for="unitPrice" class="control-label col-sm-2">Unit
			Price: </label>
		<div class="col-sm-4">
			<form:input type="text" placeholder="unitPrice" path="unitPrice"
				class="form-control" id="unitPrice" />
		</div>
		<form:errors path="unitPrice" />
	</div>



	<div class="form-group">
		<label for="category" class="control-label col-sm-2">Category:
		</label>
		<div class="col-sm-4">
			<form:select path="category" id="category" class="form-control">
				<form:option value="Country" label="Country" />
				<form:option value="Rock" label="Rock" />
				<form:option value="Funk" label="Funk" />
			</form:select>
		</div>
		<form:errors path="category" />
	</div>


	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-4">
			<input type="submit" id="btnSumbit" value="Update"
				class="btn btn-primary" />
		</div>
	</div>
</form:form>

<%@ include file="footer.jsp"%>