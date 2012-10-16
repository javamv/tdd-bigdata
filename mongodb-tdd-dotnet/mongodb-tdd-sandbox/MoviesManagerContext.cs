using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using MongoDB.Driver;

namespace mongodb_tdd_sandbox
{
    class MoviesManagerContext
    {
        MongoServer mongoServer;
        MongoDatabase mongoDatabase;

        public MoviesManagerContext()
        {
            mongoServer = MongoServer.Create();
            mongoDatabase = mongoServer.GetDatabase("movies_db");
        }

        public void InsertThreeRecords()
        {
            mongoDatabase.GetCollection<Movie>("movies_collection").Insert(new Movie{Title = "Shrek 1", Year = 2004});
            mongoDatabase.GetCollection<Movie>("movies_collection").Insert(new Movie{Title = "Star Track", Year = 2001});
            mongoDatabase.GetCollection<Movie>("movies_collection").Insert(new Movie { Title = "Star Wars", Year = 2004});
        }

        public void CleanStorage()
        {
            mongoDatabase.GetCollection<Movie>("movies_collection").RemoveAll();
        }
    }
}
