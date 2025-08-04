import { Link } from "react-router-dom";
const TrainersList = ({ trainers }) => {

  return (
    <div>
      <h1>Trainers List</h1>
      <ul>
        {trainers.map((trainer) => (
          <li key={trainer.trainerId}>
            <Link to={`/trainer/${trainer.trainerId}`}>{trainer.name}</Link>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default TrainersList;
