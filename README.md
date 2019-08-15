**Java-based assignment project for subject SWE690 - Data Science Programming**
1. #### Install and Run MongoDB with Homebrew

	-   **Open the Terminal app**  and type  `brew update`.
	-   **After updating Homebrew**  `brew install mongodb`
	-   **After downloading Mongo,**  create the “db” directory. This is where the Mongo data files will live. You can create the directory in the default location by running  `mkdir -p /data/db`
	-   **Make sure that the  `/data/db`  directory has the right permissions**  by running

	    ```
	    > sudo chown -R `id -un` /data/db
	    > # Enter your password
	    ```

	-   **Run the Mongo daemon**, in one of your terminal windows run  `mongod`. This should start the Mongo server.
	-   **Run the Mongo shell**, with the Mongo daemon running in one terminal, type  `mongo`  in another terminal window. This will run the Mongo shell which is an application to access data in MongoDB.
	-   **To exit the Mongo shell**  run  `quit()`
	-   **To stop the Mongo daemon**  hit  `ctrl-c`

2. #### Initial database and collection
	-   **Enter Mongo shell** run  `mongo`
	-   **Create "sweds" database** run  `use sweds`
	-   **Create "student" collection with initial data** run  `db.student.insert({id: "1001", name: "John Doe"})`
