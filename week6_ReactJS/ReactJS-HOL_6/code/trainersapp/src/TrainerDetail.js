 import { useParams } from "react-router-dom";

const TrainerDetails =({trainers})=>
{
const params = useParams();
const id = params.trainerId;

const trainer=trainers.find((train)=>train.trainerId===id);

return(
    <div>
        <h1>Trainers Details</h1>
        <h2>{trainer.name}({trainer.technology})</h2>
        <p>{trainer.email}</p>
        <p>{trainer.phone}</p>
        <ul>
            {trainer.skills.map((skill)=>(
            
                <li>{skill}</li>
            ))}
        </ul>
    </div>
);

}
export default TrainerDetails;