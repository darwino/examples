# Darwino Examples
Standalone non-app examples for accomplishing semi-common tasks in Darwino.

### domino-plugin

This directory contains three Eclipse projects to demonstrate how to add a Java-based plugin to the Domino Adapter DSL environment. 

To add these projects to your Eclipse workspace, make sure to add the update site from the Darwino Domino adapter distribution and IBM's [Update Site for Build Management](https://extlib.openntf.org/main.nsf/project.xsp?r=project/IBM%20Domino%20Update%20Site%20for%20Build%20Management) to your Target Platform; otherwise, you will encounter errors about Eclipse not being able to resolve Darwino and Domino packages.

After installing this plugin to your Domino server, you can add it to your database adapter scripts by adding this to the top level of the script:

```groovy
plugin "exampleConverterPlugin"
```

That name matches the name of the plugin specified in `ExampleConverterPlugin` - adjust it in the script if you adjust it in the plugin code.