using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using MongoDB.Driver;
using MongoDB.Driver.Builders;
using System.Collections;

namespace mongodb_tdd_sandbox
{
    class MoviesManager
    {
        MongoServer mongoServer;
        MongoDatabase mongoDatabase;

        public MoviesManager()
        {
            mongoServer = MongoServer.Create();
            mongoDatabase = mongoServer.GetDatabase("movies_db");
        }

        public MongoCollection FindAll()
        {
            return mongoDatabase.GetCollection<Movie>("movies_collection");
        }

        public List<Movie> FindByTitle(string Title)
        {
            return new List<Movie>(mongoDatabase.GetCollection<Movie>("movies_collection").FindAs<Movie>(Query.EQ("Title",Title)));
        }

        public List<Movie> FindByYear(int Year)
        {
            return new List<Movie>(mongoDatabase.GetCollection<Movie>("movies_collection").FindAs<Movie>(Query.EQ("Year", Year)));
        }
    }
}
