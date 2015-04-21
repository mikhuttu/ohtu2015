import ohtu.*
import ohtu.services.*
import ohtu.data_access.*
import ohtu.domain.*
import ohtu.io.*

description 'User can log in with valid username/password-combination'

scenario "user can login with correct password", {
    given 'command login selected', {
       userDao = new InMemoryUserDao()
       auth = new AuthenticationService(userDao)
<<<<<<< HEAD
       io = new StubIO("login", "pekka", "akkep")
=======
       io = new StubIO("login", "pekka", "akkep") 
>>>>>>> mluukkai-lokaali
       app = new App(io, auth)
    }

    when 'a valid username and password are entered', {
       app.run()
    }

    then 'user will be logged in to system', {
       io.getPrints().shouldHave("logged in")
    }
}

scenario "user can not login with incorrect password", {
<<<<<<< HEAD
    given 'command login selected', {
       userDao = new InMemoryUserDao()
       auth = new AuthenticationService(userDao)
       io = new StubIO("login", "pekka", "aakkep")
       app = new App(io, auth)
    }

    when 'a valid username and incorrect password are entered', {
      app.run()
    }

    then 'user will not be logged in to system', {
      io.getPrints().shouldHave("wrong username or password")
    }
}

scenario "nonexistent user can not login to ", {
    given 'command login selected', {
       userDao = new InMemoryUserDao()
       auth = new AuthenticationService(userDao)
       io = new StubIO("login", "pekka2", "kanala")
       app = new App(io, auth)
    }

    when 'a nonexistent username and some password are entered', {
      app.run()
    }

    then 'user will not be logged in to system', {
      io.getPrints().shouldHave("wrong username or password")
    }
=======
    given 'command login selected'
    when 'a valid username and incorrect password are entered'
    then 'user will not be logged in to system'
}

scenario "nonexistent user can not login to ", {
    given 'command login selected'
    when 'a nonexistent username and some password are entered'
    then 'user will not be logged in to system'
>>>>>>> mluukkai-lokaali
}