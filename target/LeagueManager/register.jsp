<!DOCTYPE html>
<html lang="en">
<%@ include file = "page/header.jsp"%>
<body>
<%@ include file = "navbar.jsp"%>
<div class="container">
    <form>
      <div class="form-row">
        <div class="col-md-4 mb-3">
          <label for="validationServer01">Team Name</label>
          <input type="text" class="form-control is-valid" id="validationServer01" placeholder="Team name">

        </div>
        <div class="col-md-4 mb-3">
          <label for="validationServer02">Status</label>
          <input type="text" class="form-control is-valid" id="validationServer02" placeholder="Status" value="Otto" required>

        </div>
        <div class="col-md-4 mb-3">
          <label for="validationServerUsername">Team code</label>
          <div class="input-group">

            <input type="text" class="form-control is-invalid" id="validationServerUsername" placeholder="Team code" aria-describedby="inputGroupPrepend3" required>
            <div class="invalid-feedback">
              Please choose a username.
            </div>
          </div>
        </div>
      </div>

      <div class="form-group">
        <div class="form-check">
          <input class="form-check-input is-invalid" type="checkbox" value="" id="invalidCheck3" required>
          <label class="form-check-label" for="invalidCheck3">
            Agree to terms and conditions
          </label>
          <div class="invalid-feedback">
            You must agree before submitting.
          </div>
        </div>
      </div>
      <button class="btn btn-primary" type="submit">Submit form</button>
    </form>
    </div>
</body>
</html>

