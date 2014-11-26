Creekridge_Portal
=================
Contains the code for the Creekridge Capital portal.


Instructions: 
------------------
1. Delete the folder with current creek ridge portlets if any in sdk/portlets
2. Open command line (Windows key + R and type cmd)
3. Navigate to the <code> {liferay sdk folder}/portlets </code>
4. Execute  <code> git clone https://github.com/TamarackConsulting/Creekridge_Portal.git  CreekRidgeCapital-portlet </code> This should create a folder in portlets. 
5. Open Eclipse and create new Liferay project from existing source.
6. Run ANT clean and ANT compile targets.
7. If you are having issues, go to service.xml and right click >  Liferay > Build Services (do NOT build WSSD!)

Alternative to steps 2-4 using Eclipse:
----------------------------------------
Note: Steps 2-4 from above can also be done from Eclipse using the following steps:

2. From Eclipse, click on File > Import
3. From the import screen, click on Git > "Projects from Git" > Click Next
4. From the "Import Projects from Git" screen, click on Clone URI.
5. From the "Source Repository" screen, in the URI paste in "https://github.com/TamarackConsulting/Creekridge_Portal.git". You can choose to enter a username and password but it's in a public repository so it isn't necessary. Click Next.
6. From the "Branch Selection" screen, select "Master" only and click Next
7. From the Local Destination screen, in the Directory field, browse to the {liferay sdk folder}/portlets folder and in the browse file name field enter "CreekRidgeCapital-portlet" and click Save
8. Configure the remote github with a name at the bottom of the screen and click next.
9. On the next screen, choose to Import projects from Existing and navigate to the CreekridgeCapital-portlet folder in the sdk\portlets folder.
10. The project will be created with all contents from github.
11. Do steps 6 and 7 listed above.

9 steps instead of 3 for those of us who feel safer with the Eclipse GUI :)



test again

test
