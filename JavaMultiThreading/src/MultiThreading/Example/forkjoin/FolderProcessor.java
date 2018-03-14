package MultiThreading.Example.forkjoin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FolderProcessor extends RecursiveTask<List<String>> {

	//This attribute will store the full path of the folder this task is going to process.
	private final String      path;
	//This attribute will store the name of the extension of the files this task is going to look for.
	private final String      extension;


	//Implement the constructor of the class to initialize its attributes
	public FolderProcessor(String path, String extension)
	{
		this.path = path;
		this.extension = extension;
	}


	@Override
	protected List<String> compute() {
		// TODO Auto-generated method stub

		//result list will add the calculated path of the subfolders
		List<String> list = new ArrayList<String>();

		//FolderProcessor tasks to store the subtasks that are going to process the subfolders stored in the folder
		List<FolderProcessor> tasks = new ArrayList<FolderProcessor>();

		//Get the content of the folder.
		File file = new File(path);
		File content[] = file.listFiles();
		//For each element in the folder, if there is a subfolder, create a new FolderProcessor object
		//and execute it asynchronously using the fork() method.

		for (int i =0;i<content.length;i++) {
			File contentFile = content[i];
			if (contentFile.isDirectory()) {
				FolderProcessor task = new FolderProcessor(contentFile.getAbsolutePath(), extension);
				task.fork();
				tasks.add(task);

			}

			//Otherwise, compare the extension of the file with the extension you are looking for using the checkFile() method
			//and, if they are equal, store the full path of the file in the list of strings declared earlier.
			else {
				if (checkFile(contentFile.getName())) {
					list.add(contentFile.getAbsolutePath());
				}
			}

		}

		addResultsFromTasks(list, tasks);
		return list;
	}

	//For each task stored in the list of tasks, call the join() method that will wait for its finalization and then will return the result of the task.
	//Add that result to the list of strings using the addAll() method.
	private void addResultsFromTasks(List<String> list, List<FolderProcessor> tasks)
	{
		for (FolderProcessor item : tasks)
		{
			list.addAll(item.join());
		}
	}
	//This method compares if the name of a file passed as a parameter ends with the extension you are looking for.
	private boolean checkFile(String name)
	{
		return name.endsWith(extension);
	}

}
