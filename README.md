Creekridge_Portal
=================

Contains the code for the Creekridge Capital portal.


Instructions: 


1. Delete the folder with current creek ridge portlets if any in sdk/portlets
2. Open command line (Windows key + R and type cmd)
3. Navigate to the <code> {liferay sdk folder}/portlets </code>
4. Execute  <code> git clone https://github.com/TamarackConsulting/Creekridge_Portal.git  CreekRidgeCapital-portlet </code> This should create a folder in portlets. 
5. Open Eclipse and create new Liferay project from existing source.
6. Run ANT clean and ANT compile targets.
7. If you are having issues, go to service.xml and right click >  Liferay > Build Services (do NOT build WSSD!)
