using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using MongoDB.Bson;

namespace mongodb_tdd_sandbox
{
    class Movie
    {
        public BsonObjectId Id { get; set; }
        public string Title { get; set; }
        public int Year { get; set; }
    }
}
