insert into wiremock_mapping (request_method, request_url, request_body, request_type, response_body)
values ('GET','/helloWorld', null, 'REST', '{
    "name": "Java Book",
    "author": "O’Reilly",
    "pages": 800,
    "collection": "JAVA",
    "innerObject": {
        "innerField": "Hello",
        "andCheck": 11
    },
    "users": [
        {
            "id": 1,
            "name": "Nishant"
        },
        {
            "id": 1,
            "name": "Shivani"
        },
        {
            "id": 1,
            "name": "Shivanishant"
        }
    ]
}');

insert into wiremock_mapping (request_method, request_url, request_body, request_type, response_body)
values ('GET','/favicon.ico', null, 'REST', 'Hello from Wires Wiremock!!');