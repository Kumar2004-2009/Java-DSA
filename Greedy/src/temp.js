db.createCollection("nonfiction",{
    validator:{
        $jsonSchema:{
            required:["name","price"],
            properties:{
                name:{
                    bsonType:"string",
                    description:"must be a string and is required"
                },
                price:{
                    bsonType:"number",
                    description:"must be a number and is required"
                }
            }
        }
    },
    validationAction:"error"
})

db.runCommand({
    collMod:"nonfictions",
    validator:{
        $jsonSchema:{
            required:["name","price","author"],
            properties:{
                name:{
                    bsonType:"string",
                    description:"must be a string and is required"
                },
                price:{
                    bsonType:"number",
                    description:"must be a number and is required"
                },
                author:{
                    bsonType:"array",
                    description:"must be an array and is required",
                    items:{
                        bsonType:"object",
                        required:["name","email"],
                        properties:{
                            name:{
                                bsonType:"string",
                                description:"must be a string and is required"
                            },
                            email:{
                                bsonType:"string",
                                description:"must be a string and is required"
                            },
                        }

                    }
                }
            }
        }
    },
    validationAction:"error"
})

db.teachers.insertMany([{_id:1,name:'John',age:30,gender:'male'},
    {_id:2,name:'Jane',age:25,gender:'female'},
    {_id:3,name:'Michael',age:35,gender:'male'},
    {_id:4,name:'Emily',age:28,gender:'female'},
    {_id:5,name:'David',age:40,gender:'male'},
    {_id:6,name:'Samantha',age:32,gender:'female'},
    {_id:7,name:'Chris',age:45,gender:'male'},
    {_id:8,name:'Ashley',age:27,gender:'female'},
    {_id:9,name:'James',age:29,gender:'male'},
    {_id:10,name:'Jessica',age:33,gender:'female'},
    {_id:11,name:'Robert',age:31,gender:'male'},
    {_id:12,name:'Alicia',age:26,gender:'female'},
    {_id:13,name:'Mike',age:36,gender:'male'},
    {_id:14,name:'Katie',age:29,gender:'female'},
    {_id:15,name:'Jason',age:41,gender:'male'},
    {_id:16,name:'Sarah',age:33,gender:'female'},
    {_id:17,name:'Mark',age:36,gender:'male'},
    {_id:18,name:'Megan',age:28,gender:'female'},
    {_id:19,name:'Scott',age:30,gender:'male'},
    {_id:20,name:'Lauren',age:34,gender:'female'}
])