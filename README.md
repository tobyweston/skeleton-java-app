# Skeleton Java app

A skeleton Java web app with no web framework.

## Create Your Own Fork

Fork this project to create a repo under your own GitHub account, so that you can commit and push to it.
Then clone the code from your fork onto your machine.


## Install Dependencies

Make sure you have a JDK and a Java IDE installed. The skeleton web app is configured as a Maven project,
so if you import it in to an IDE (e.g. IntelliJ IDEA) as a Maven project then it should download any
dependencies as necessary.


## Running Locally

If you open the project in an IDE, you should find a class called `WebServer` which has a `main` method.
If you run this main method then the web server should start up on your local machine.


Your app should now be running on http://localhost:5000.

Now try the following request in your browser: http://localhost:5000/api?q=Who%20wrote%20Romeo%20and%20Juliet?
This should call the code in `QueryProcessor.java`.


## Run the unit tests

The skeleton app comes with a small set of unit tests (see the file `QueryProcessorTest`), which you can add to as you 
add functionality. Run the tests using jUnit in your IDE, or from the terminal using Maven.

```sh
$ cd skeleton-java-app
$ mvn test
```


## Enabling Travis CI

Just `Add Respository` on the left, find your new repository a click the slider to enable.


## Link Heroku

1. Add generated Heroku Git remote to your local Git repository

    This is adding a Git `remote` to your local repository so that you can run `git push heroku master` to deploy it manually.

    Running the following on its own doesn't work (as you won't have credentials setup)

    ```
    git remote add heroku https://git.heroku.com/robbie-spike-horse-bucket.git
    ```
    
    Use the Heroku CLI instead which asks for your credentials and logs you in somehow (as well as adding the remote above)
    
    ```
    heroku git:remote -a robbie-spike-horse-bucket
    ```
    
    Test at [https://robbie-spike-horse-bucket.herokuapp.com](https://robbie-spike-horse-bucket.herokuapp.com/api?q=romeo%20and%20juliet)
    
2. Deploy automatically on push

    1. Run `heroku auth:token` to generate an Heroku authorisation token. 
    1. You would encrypt this value with the `travis` command but if you don't have the Travis CLI installed, use [this site](http://rkh.github.io/travis-encrypt/public/index.html) (use something like `tobyweston/skeleton-java-app` for the repository field)
    1. Create a `deploy` section to your `travis.yml` (see the [Heroku docs](https://docs.travis-ci.com/user/deployment/heroku/))
    1. Add the encrypted value to the `deply` section of your `travis.yml`.