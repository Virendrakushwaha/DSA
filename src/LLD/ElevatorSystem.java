package LLD;

/*

Elevator System
------------------------------

Elevator System
Functional Requirements:
    The System should be able to support N number of elevator
    A user should be able to make a hall call - Press UP or DOWN
    A user inside an elevator can make a cabin call - select a destination floor
    The system should support multiple algorithms for elevator selection
    Each elevator has a direction(UP/DOWN/IDLE) and states (MOVING, STOPPED, IDLE)
    The system should have an ElevatorController managing request and assigning elevator
    ----- Good To have ----- OUT of SCOPE ---
    Capacity Overload handling
    DisplayBoard on each floor
    Emergency handling

Non-Functional:
    Scalability - adding elavtors should'nt require design changes
    Extensibility
    Thread-safety
        --> Each elevator is running in it's own thread
        --> multiple users should be able make the calls
        --> maintain the consistency in between multiple calls
    Clean and SOLID principle adhearing code...

Core Entities:
    Elevator --->
        addInternalRequest()
    Request
    SchedulingStrategy
        Concrete Stategies
        NearestElevatorStrategy
    Direction, ElevatorState, DoorState

*/

import java.util.*;

class Elevator {
    private int id;
    private int currentFloor;
    private ElevatorState elevatorState;
    private Direction direction;
    private DoorState doorState;
    private boolean isRunning = false;
    private PriorityQueue<Integer> upStops = new PriorityQueue<>();  //min heap
    private PriorityQueue<Integer> downStops = new PriorityQueue<>((a, b) -> b - a);  //max heap

    void addDestination(int floor) {
        if (floor < currentFloor)
            downStops.add(floor);
        else
            upStops.add(floor);
    }

    void run() {
        isRunning = true;
        while (!upStops.isEmpty()) {
            if (upStops.peek() == currentFloor) {
                System.out.println("lift open for " + currentFloor + "floor");
                upStops.poll();
            } else if (upStops.peek()>currentFloor) {
                currentFloor++;
            }
            else
                currentFloor--;
        }

        while (!downStops.isEmpty()) {
            if (downStops.peek() == currentFloor) {
                System.out.println("lift open for " + currentFloor + "floor");
                downStops.poll();
            }

        }

    }
}

enum ElevatorState{MOVING, STOPPED, IDLE}

enum Direction{UP,DOWN,IDLE}

enum DoorState{OPEN,CLOSED}

class Request{
    Direction direction;
    int floor;

    Request(Direction direction,int floor){
        this.direction = direction;
        this.floor = floor;
    }
}

interface SchedulingStrategy{
    void nearestElevatorStrategy(Queue<Request> requestsQueue);
}

public class ElevatorSystem implements SchedulingStrategy{
    private final Request req;
    Queue<Request> requestsQueue = new LinkedList<>();

    ElevatorSystem(Request req){
        this.req = req;
    }


    List<Elevator> elevatorList = new ArrayList<>();
    void addElevators(Elevator elevator){
        elevatorList.add(elevator);
    }
    void removeElevators(Elevator elevator){
        elevatorList.remove(elevator);
    }

    void addInternalRequest() {
        for (Elevator elevator: elevatorList) {
            elevator.addDestination(req.floor);
        }
    }

    @Override
    public void nearestElevatorStrategy(Queue<Request> requestsQueue) {
        //
        while(!requestsQueue.isEmpty()){
            //up going queue
           if(requestsQueue.peek().direction.equals("UP")){

           }
            //down going queue
        }

    }
}
