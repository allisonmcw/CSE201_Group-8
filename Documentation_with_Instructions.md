# CSE201_Group-8
This is our project for CSE 201. 

# Team Credits 
<b><i>TAJI Inc.</b></i>
<br>Founded 2021
<br>
<br><i>Members</i>
<p style="margin-left: 10px">Jenn Pham: Project Manager</p>
<p style="margin-left: 10px">Allison McWilliams: Technical Manager</p> 
<p style="margin-left: 10px">Isabel Pulte: Developer (50% Documentation)</p>
<p style="margin-left: 10px">Tanmay Bhatkar: Developer (50% Coding)</p>

# Requirement lists: 
1. The software shall be accessible through a GUI.
2. The software shall allow users to view all the applications.
3. The software shall be able to sort all the applications.
4. The software shall allow users to filter all applications in the repository.
5. The software can search for an application.
6. The software shall allow users to be able to add applications to the repository by submitting a request form.
7. The software shall allow admins to have access to a request page with all app submits requests.
8. The software shall allow moderators to moderate a comment section for each app.
9. The software shall require all users to login in in order to post on the forum.
10. The software shall have the backend of the repository and user login information persisted.

# Installation/compilation instructions:
Download the ZIP file and open it using your IDE of choice.
<br><b><i>We encourage you to use Eclipse. Below is instructions to create a project from the ZIP file in Eclipse</b></i>
<ol>
	<li>Click File -> Import from the Eclipse main menu</li>
	<li>Expand General, select Existing Projects into Workspace, and click Next</li>
	<li>Make sure that Select Archive File is checked and browse for CSE201_Group-8.zip and browse for the ZIP file</li>
	<li>Click Finish</li>
</ol>
<br><b><i>You should now see the new project in Package Explorer.</b></i>
<br><b><i> To make test files work, simply add JUnit 5 into the library.</b></i>

# Running instructions:
1. Open the project that was imported using ZIP file.
2. There should be 3 folders (<b>default package (created by Eclipse)</b>, <b>accounts</b>, and <b>icons</b>) and 5 single files.
3. Open <b>default package</b> and run the main file <b>GUI.java</b>.
4. You're at the home page with all the application available.
5. Try the search function on the left side: Make sure the search is Case Sensitive.
6. Try login or create a new account using the login/create account button.
	<br>a. You must specify which type of user you want to be.
	<br>b. Case-sensitive
	<br>c. Here is a list of existing accounts for you to sign in:
	<ol>
		<li> User: (Name: user; Password: password).</li>
		<li> Administrator: (Name: admin; Password: password).</li>
		<li> Moderator: (Name: mod; Password: password).
	</ol>
7. Try sort the applications by alphabet using the sort button. Press UnSort to unsort the applications.</li>
8. Try filter the applications using the filter bar above the page. Lots of options to choose from!
9. After logging in as a user: 
	<br>a. Comment on an app using the "Comment Here!" button.
	<ol>
		<li>Leads to a different frame. <b>WARNING: DO NOT PRESS CLOSE, SIMPLE PRESS MINIMIZE TO EXIT BECAUSE IF PRESSED CLOSED IT WILL CLOSE THE WHOLE MAIN FRAME.</b></li>
		<li>Choose an app to comment on. Leads to an app table.</li>
		<li>You cannot delete any comment; for administrator and moderator only.</li>
	</ol>
	b. Request a new app by clicking the "All Requests" button. Leads to an app request form.
	<br>c. After refreshing the GUI by clicking the Sort/UnSort button, app will display without a picture, this will be modified by an administrator.
10. After logging in as an administrator: 
	<br>a. Comment on an app using the "Comment Here!" button.
	<ol>
		<li>Leads to a different frame. <b>WARNING: DO NOT PRESS CLOSE, SIMPLE PRESS MINIMIZE TO EXIT BECAUSE IF PRESSED CLOSED IT WILL CLOSE THE WHOLE MAIN FRAME.</b></li>
		<li>Choose an app to comment on. Leads to an app table.</li>
		<li>Delete a comment by entering its number and press "Delete".</li>
	</ol>
	b. Request a new app by clicking the "All Requests" button. Leads to an app request form.
	<br>c. After refreshing the GUI by clicking the Sort/UnSort button, app will display without a picture, this will be modified by an administrator.
	<br>d. Accept an app request by clicking approve.
11. After loggin in as a moderator: 
	<br>a. Comment on an app using the "Comment Here!" button.
	<ol>
		<li>Leads to a different frame. <b>WARNING: DO NOT PRESS CLOSE, SIMPLE PRESS MINIMIZE TO EXIT BECAUSE IF PRESSED CLOSED IT WILL CLOSE THE WHOLE MAIN FRAME.</b></li>
		<li>Choose an app to comment on. Leads to an app table.</li>
		<li>Delete a comment by entering its number and press "Delete".</li>
	</ol>
	b. Request a new app by clicking the "All Requests" button. Leads to an app request form.
	<br>c. After refreshing the GUI by clicking the Sort/UnSort button, app will display without a picture, this will be modified by an administrator.
12. At the main GUI, try clicking on each app to see its respective information. 
13. To exit the app, simply press close on the window.

# Lists of Files
<ol type=A>
	<li>Functional Java files:</li>
		<ol>
			<li>admin.java</li>
			<li>App.java</li>
			<li>commentDriver.java</li>
			<li>filterDriver.java</li>
			<li>GUI.java</li>
			<li>login.java</li>
			<li>SortedGUI.java</li>
		</ol>
	<li>JUnit Testers:</li>
		<ol>
			<li>AppTest.java</li>
			<li>filterDriverTest.java</li>
			<li>GUITest.java</li>
		</ol>
	<li>Account storage files:</li>
		<ol>
			<li>Accounts.txt</li>
			<li>Admin.txt</li>
			<li>Moderator.txt</li>
		</ol>
	<li>Icon Images File: icons</li>
	<li>Application Information - Sheet1 (1).csv</li>
	<li>Diagrams.docx</li>
	<li>Documentation_with_Instructions.md</li>
	<li>README.md</li>
	<li>Technical Skills and Goals</li>
	<li>.gitignore</li>
</ol>

# PLEASE CONTACT US IMMEDIATELY IF THE PROGRAM CANNOT READ IN THE FILES
There might be some errors around the file path. 
