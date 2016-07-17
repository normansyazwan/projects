<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>




<div class="page-header">
	<h3>Patient Assesment Form</h3>
	<h5>Assesment of ailment</h5>
</div>

<form:form method="POST" commandName="assesment"
	cssClass="form-horizontal">
	<div class="container-fluid" >
		<div class="row">
		
			<div class="col-sm-1"></div>
			<div class="col-sm-11" >
		
				<spring:bind path="presentCondition">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="presentCondition"
							cssClass="col-sm-2 control-label">Present Condition</form:label>
						<div class="col-sm-3">
							<form:textarea path="presentCondition" value="${presentCondition}"
								cssClass="form-control"
								placeholder="Present Condition of patient" maxlength="255" rows="3" cols="180"/>
						</div>
					</div>
				</spring:bind>
				
				<spring:bind path="onset">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="onset"
							cssClass="col-sm-2 control-label">Onset</form:label>
						<div class="col-sm-3">
							<form:textarea path="onset" value="${onset}"
								cssClass="form-control"
								placeholder="Onset" maxlength="255" rows="3" cols="180"/>
						</div>
					</div>
				</spring:bind>

				<spring:bind path="duration">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="duration"
							cssClass="col-sm-2 control-label">Duration</form:label>
						<div class="col-sm-3">
							<form:textarea path="duration" value="${duration}"
								cssClass="form-control"
								placeholder="e.g. last 15 days" maxlength="255" rows="3" cols="180"/>
						</div>
					</div>
				</spring:bind>
				
				<spring:bind path="surgicalHistory">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="surgicalHistory"
							cssClass="col-sm-2 control-label">Surgical History</form:label>
						<div class="col-sm-3">
							<form:input path="surgicalHistory" value="${surgicalHistory}"
								cssClass="form-control"
								placeholder="Surgical History" maxlength="255" />
						</div>
					</div>
				</spring:bind>
				
				
				<spring:bind path="redFlag">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="redFlag"
							cssClass="col-sm-2 control-label">Red Flag</form:label>
						<div class="col-sm-3">
							<form:input path="redFlag" value="${redFlag}"
								cssClass="form-control"
								placeholder="Red Flag" maxlength="255"/>
						</div>
					</div>
				</spring:bind>
				
				
				<spring:bind path="physiotherapyTreatmentHistory">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="physiotherapyTreatmentHistory"
							cssClass="col-sm-2 control-label">Physiotherapy Treatment History</form:label>
						<div class="col-sm-3">
							<form:textarea path="physiotherapyTreatmentHistory" value="${physiotherapyTreatmentHistory}"
								cssClass="form-control"
								placeholder="Details of any physiotherapy treatment related to this ailment" maxlength="255" rows="3" cols="180"/>
						</div>
					</div>
				</spring:bind>
				
				<spring:bind path="currentExercises">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="currentExercises"
							cssClass="col-sm-2 control-label">Current Exercises</form:label>
						<div class="col-sm-3">
							<form:textarea path="currentExercises" value="${currentExercises}"
								cssClass="form-control"
								placeholder="Is patient doing any exercises at home?" maxlength="255" rows="3" cols="180"/>
						</div>
					</div>
				</spring:bind>
				
				<spring:bind path="hobbiesAndSports">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="hobbiesAndSports"
							cssClass="col-sm-2 control-label">Hobbies And Sports</form:label>
						<div class="col-sm-3">
							<form:textarea path="hobbiesAndSports" value="${hobbiesAndSports}"
								cssClass="form-control"
								placeholder="Does patient have any hobbies or play any sport that could lead to this ailment" maxlength="255" rows="3" cols="180"/>
						</div>
					</div>
				</spring:bind>												
					
					
				<spring:bind path="familyHistory">
					
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="familyHistory"
							cssClass="col-sm-2 control-label">Family History</form:label>
						<div class="col-sm-3">
							<form:textarea path="familyHistory" value="${familyHistory}"
								cssClass="form-control"
								placeholder="Does patient have a family history related to this ailment" maxlength="255" rows="3" cols="180"/>
						</div>
					</div>
				</spring:bind>	
						
				<hr/>
				
				<spring:bind path="swelling">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="swelling"
							cssClass="col-sm-2 control-label">Swelling</form:label>
						<div class="col-sm-3">
							<form:input path="swelling" value="${swelling}"
								cssClass="form-control"
								placeholder="Does patient have any hobbies or play any sport that could lead to this ailment" maxlength="255"/>
						</div>
					</div>
				</spring:bind>			
				
				<spring:bind path="areaOfPain">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="areaOfPain"
							cssClass="col-sm-2 control-label">Area Of Pain</form:label>
						<div class="col-sm-3">
							<form:input path="areaOfPain" value="${areaOfPain}"
								cssClass="form-control"
								placeholder="Area of pain" maxlength="255" />
						</div>
					</div>
				</spring:bind>			
				
				<spring:bind path="deformity">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="deformity"
							cssClass="col-sm-2 control-label">Deformity</form:label>
						<div class="col-sm-3">
							<form:input path="deformity" value="${deformity}"
								cssClass="form-control"
								placeholder="Has this ailment caused any deformity?" maxlength="255" />
						</div>
					</div>
				</spring:bind>			
				
				
				<spring:bind path="gait">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="gait"
							cssClass="col-sm-2 control-label">Gait</form:label>
						<div class="col-sm-3">
							<form:input path="gait" value="${gait}"
								cssClass="form-control"
								maxlength="255" />
						</div>
					</div>
				</spring:bind>			
				
				<spring:bind path="built">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="built"
							cssClass="col-sm-2 control-label">Built</form:label>
						<div class="col-sm-3">
							<form:input path="built" value="${built}"
								cssClass="form-control"
								maxlength="255" />
						</div>
					</div>
				</spring:bind>

				<hr/>

				<spring:bind path="warmth">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="warmth"
							cssClass="col-sm-2 control-label">warmth</form:label>
						<div class="col-sm-3">
							<form:input path="warmth" value="${warmth}"
								cssClass="form-control"
								maxlength="255" />
						</div>
					</div>
				</spring:bind>			
				
				<spring:bind path="muscleSpasm">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="muscleSpasm"
							cssClass="col-sm-2 control-label">Muscle Spasm</form:label>
						<div class="col-sm-3">
							<form:input path="muscleSpasm" value="${muscleSpasm}"
								cssClass="form-control"
								maxlength="255" />
						</div>
					</div>
				</spring:bind>			
				
				<spring:bind path="tenderness">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="tenderness"
							cssClass="col-sm-2 control-label">tenderness</form:label>
						<div class="col-sm-3">
							<form:input path="tenderness" value="${tenderness}"
								cssClass="form-control"
								maxlength="255" />
						</div>
					</div>
				</spring:bind>
				
				<hr/>

				<spring:bind path="vasScale">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="vasScale"
							cssClass="col-sm-2 control-label">vasScale</form:label>
						<div class="col-sm-3">
							<form:input path="vasScale" value="${vasScale}"
								cssClass="form-control"
								maxlength="255" />
						</div>
					</div>
				</spring:bind>
				
				<spring:bind path="aggrevatingFactors">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="aggrevatingFactors"
							cssClass="col-sm-2 control-label">Aggrevating Factors</form:label>
						<div class="col-sm-3">
							<form:input path="aggrevatingFactors" value="${aggrevatingFactors}"
								cssClass="form-control"
								maxlength="255" />
						</div>
					</div>
				</spring:bind>
				
				<spring:bind path="rom">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="rom"
							cssClass="col-sm-2 control-label">ROM</form:label>
						<div class="col-sm-3">
							<form:input path="rom" value="${rom}"
								cssClass="form-control"
								maxlength="255" />
						</div>
					</div>
				</spring:bind>
				
				<spring:bind path="endFeel">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="endFeel"
							cssClass="col-sm-2 control-label">End Feel</form:label>
						<div class="col-sm-3">
							<form:input path="endFeel" value="${endFeel}"
								cssClass="form-control"
								maxlength="255" />
						</div>
					</div>
				</spring:bind>
				
				<spring:bind path="mmt">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="mmt"
							cssClass="col-sm-2 control-label">MMT</form:label>
						<div class="col-sm-3">
							<form:input path="mmt" value="${mmt}"
								cssClass="form-control"
								maxlength="255" />
						</div>
					</div>
				</spring:bind>																

				<spring:bind path="specialTests">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="specialTests"
							cssClass="col-sm-2 control-label">Special Tests</form:label>
						<div class="col-sm-3">
							<form:input path="specialTests" value="${specialTests}"
								cssClass="form-control"
								maxlength="255" />
						</div>
					</div>
				</spring:bind>																

				<spring:bind path="neurological">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="neurological"
							cssClass="col-sm-2 control-label">neurological</form:label>
						<div class="col-sm-3">
							<form:input path="neurological" value="${neurological}"
								cssClass="form-control"
								maxlength="255" />
						</div>
					</div>
				</spring:bind>																

				<spring:bind path="cardiorespiratory">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="cardiorespiratory"
							cssClass="col-sm-2 control-label">Cardiorespiratory</form:label>
						<div class="col-sm-3">
							<form:input path="cardiorespiratory" value="${cardiorespiratory}"
								cssClass="form-control"
								maxlength="255" />
						</div>
					</div>
				</spring:bind>																


				<spring:bind path="functionalAssesment">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="functionalAssesment"
							cssClass="col-sm-2 control-label">Functional Assesment</form:label>
						<div class="col-sm-3">
							<form:input path="functionalAssesment" value="${functionalAssesment}"
								cssClass="form-control"
								maxlength="255" />
						</div>
					</div>
				</spring:bind>																


				<spring:bind path="wellnessAssesment">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="wellnessAssesment"
							cssClass="col-sm-2 control-label">Wellness Assesment</form:label>
						<div class="col-sm-3">
							<form:input path="wellnessAssesment" value="${wellnessAssesment}"
								cssClass="form-control"
								maxlength="255" />
						</div>
					</div>
				</spring:bind>																


				<spring:bind path="recoveryPotential">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="recoveryPotential"
							cssClass="col-sm-2 control-label">Recovery Potential</form:label>
						<div class="col-sm-3">
							<form:input path="recoveryPotential" value="${recoveryPotential}"
								cssClass="form-control"
								maxlength="255" />
						</div>
					</div>
				</spring:bind>																


				<spring:bind path="therapyPlan">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<form:label path="therapyPlan"
							cssClass="col-sm-2 control-label">Therapy Plan</form:label>
						<div class="col-sm-3">
							<form:input path="therapyPlan" value="${therapyPlan}"
								cssClass="form-control"
								maxlength="255" />
						</div>
					</div>
				</spring:bind>																

				<hr/>

				<div class="row">
					<div class="col-sm-2"></div>
					<div class="col-sm-10">
						<button value="cancel" class="btn btn-default ">Cancel</button>
						<input type="submit" value="Save" class="btn btn-success" />
					</div>
				</div>

			</div>
		</div>
	</div>
</form:form>
