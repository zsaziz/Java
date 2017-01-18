public class DogTeam {

  private LLDogNode head;

  public DogTeam(Dog dog) {
    head = new LLDogNode(dog, null);
  }

  public void printTeam() {
    LLDogNode cur = head;
    int dogNumber = 1;
    
    System.out.println("----------------");
    while (cur != null) {
      System.out.println(dogNumber + ". " + cur.getContents().getName() +
                         ", " + cur.getContents().getWeight());
      cur = cur.getLink();
      dogNumber += 1;
    }
  }


  public static void main(String[] args) {		
    
    DogTeam team = new DogTeam(new Dog("dog1", 60));		
    team.printTeam();
    System.out.println("weightDiff: " + team.weightDiff());
    
    team.insertTail(new Dog("dog0",  5));
    team.insertHead(new Dog("dog2",  90));
    team.printTeam();
    System.out.println("weightDiff: " + team.weightDiff());
    
    team.insertHead(new Dog("dog3",  7));
    team.insertTail(new Dog("dog4",  100));
    team.insertTail(new Dog("dog10", 205));		
    team.printTeam();
    System.out.println("weightDiff: " + team.weightDiff());
    
  }

  public void insertHead(Dog dog) {
    // TODO(0)
    // puts new node containing dog at the head of the list
	  LLDogNode temp = new LLDogNode(dog,head);
	  head = temp;


















  }

  public void insertTail(Dog dog) {
    // TODO(1)
    // puts new node containing dog at the tail of the list
	  LLDogNode currNode = head;
	  while (currNode.getLink() != null){
		  currNode = currNode.getLink();
	  }
	  LLDogNode temp = new LLDogNode(dog,null);
	  currNode.setLink(temp);

















  }

  public double weightDiff() {
    // TODO(2)
    // returns difference between max and min weights of dogs in list
    // pre: this list contains at least one node
	  LLDogNode currNode = head;
	  double max = currNode.getContents().getWeight();
	  double min = currNode.getContents().getWeight();
	  while (currNode != null){
		  if (currNode.getContents().getWeight() > max)
			  max = currNode.getContents().getWeight();
		  else if (currNode.getContents().getWeight() < min)
			  min = currNode.getContents().getWeight();
		  currNode = currNode.getLink();
	  }
    return max - min;


















  }
}
