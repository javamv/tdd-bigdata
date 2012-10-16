using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using NUnit.Framework;
using MongoDB.Driver;

namespace mongodb_tdd_sandbox
{
    class WhenYouFindAllMovies
    {

        MoviesManagerContext context;

        [SetUp]
        public void SetupContext()
        {
            context = new MoviesManagerContext();
            context.CleanStorage();
            context.InsertThreeRecords();
        }
        
        [Test]
        public void shouldReturnThreeMovies()
        {
            var moviesManager = new MoviesManager();
            Assert.That(moviesManager.FindAll().Count(), Is.EqualTo(3));
        }

        [Test]
        public void shouldFindMovieByTitle()
        {
            var moviesManager = new MoviesManager();
            Assert.That(moviesManager.FindByTitle("Star Wars").Count(), Is.EqualTo(1));
        }

        [Test]
        public void shouldFindMovieByYear()
        {
            var moviesManager = new MoviesManager();
            List<Movie> movies = moviesManager.FindByYear(2004);
            Assert.That(movies.Count(), Is.EqualTo(2));
            Assert.That(movies.Count(movie => movie.Title == "Star Wars"), Is.EqualTo(1));
            Assert.That(movies.Count(movie => movie.Title == "Shrek 1"), Is.EqualTo(1));
        }
    }
}