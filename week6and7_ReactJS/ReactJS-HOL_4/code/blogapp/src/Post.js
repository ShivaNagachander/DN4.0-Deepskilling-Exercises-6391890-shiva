import React from'react';
class Post
{
    constructor(id,title,body)
    {
        this.id=id;
        this.title=title;
        this.body=body;
    }
}

export default Post;

export class Posts extends React.Component
{
    constructor(props)
    {
        super(props);
        this.state = {
            posts: []
        };
    }
    loadPosts()
    {
        fetch("https://jsonplaceholder.typicode.com/posts")
        .then(response=>response.json())
        .then(data=>
        {
            const post_data=data.map(item=> new Post(item.id,item.title,item.body));
            this.setState({posts:post_data});
        }
        )
    }
    componentDidMount()
    {
        this.loadPosts();
    }
    render() {
        return (
            <div>
                {this.state.posts.map((item) => (
                    <div>
                        <h1>{item.title}</h1>
                        <p>{item.body}</p>
                    </div>
                ))}
            </div>
        );
    }

    componentDidCatch(error,info)
    {
        console.error("Component error:", error, info);
    }
}