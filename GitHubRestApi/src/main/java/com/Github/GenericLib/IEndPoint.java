package com.Github.GenericLib;

public interface IEndPoint {
	String addSingleRepo="/user/repos";
	String getAllRepo="/users/{username}/repos";
	String deleteRepo="/repos/{owner}/{repo}";

}
