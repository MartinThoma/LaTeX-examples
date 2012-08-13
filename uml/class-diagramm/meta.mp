input metauml;
beginfig(1);
    Class.LittlePraktomat("LittlePraktomat")
		("-tutors: Set<Tutor>",
		 "-currentTutor: Tutor",
		 "-students: Set<Student>",
		 "-tasks: Map<Integer,Task>",
		 "-nextTaskId: int",
		 "-solutions: Set<solution>")
		("+addTutor(Tutor): void",
		 "+addStudent(Student): void",
		 "+addTask(String): int",
		 "+containsTutor(Tutor): boolean",
		 "+containsTask(int): boolean",
		 "+getCurrentTutor(): Tutor",
		 "+setCurrentTutor(Tutor): void",
		 "+getTutors(): Set",
		 "+getStudents(): Set",
		 "+getStudentsByStudentNr(int): Student",
		 "+getTasks(): Map",
		 "+getSolutionsToTask(): int",
		 "+getReviewedSolutions(int): int",
		 "+getDistribution(int): int[]",
		 "+getStudentsByGrade(): List"
		 );
	classStereotypes.LittlePraktomat("<<AverageGrade>>");

    Class.Person("Person")
		("-name: String",
		 "+REGEX_NAME: String"
		)
		("+Person(String): void",
		 "+getName(): String"
		 );

    Class.Student("Student")
		("-studentNumber: int",
		 "+REGEX_STUD_NUMBER: String",
		 "-myTutor: Tutor",
		 "-solutions: Map<Integer,Solution>",
		)
		("+Student(String,int,Tutor): void",
		 "+getStudentNumber(): int",
		 "+getTutor(): Tutor",
		 "+getSolution(): int",
		 "+submitSolution(Solution): void"
		 );
	classStereotypes.Student("<<Comparable>>", "<<AverageGrade>>");

    Class.Review("Review")
		("-grade: int",
		 "-text: String",
		 "-solution: Solution"
		)
		("+Review(int,String,Solution): void",
		 "+getGrade(): int",
		 "+getText(): String",
		 "+getSolution(): Solution"
		 );

    Class.Solution("Solution")
		("-author: Student",
		 "-taskID: int",
		 "-text: String",
		 "-review: Review"
		)
		("+Solution(int,String,Student): void",
		 "+getText(): String",
		 "+getTask(): Task",
		 "+getAuthor(): Student",
		 "+getReview(): Review",
		 "+setReview(Review): void"
		 );

    Class.Tutor("Tutor")
		("-students: Set<Student>",
		 "-missingReviews: Set<Solution>",
		 "-reviewsDone: Set<Review>"
		)
		("+Tutor(String): void",
		 "+addStudent(Student): void",
		 "+getStudentCount(): int",
		 "+review(int,Student,int,String): boolean",
		 "+addMissingReview(Solution): void",
		 "+getmissingReviewCount(): int",
		 "+compareTo(Tutor): int"
		 );
	classStereotypes.Tutor("<<Comparable>>", "<<AverageGrade>>");

    Class.Task("Task")
		("-id: int",
		 "-text: String",
		 "-solutions: Set<Solution>"
		)
		("+Task(int, String): void",
		 "+addSolution(Solution): void",
		 "+getText(): String",
		 "+getId(): int",
		 "+getSolutions(): Set<Solution>"
		 );
	classStereotypes.Task("<<AverageGrade>>");

	topToBottom(20)(Student, Person, Tutor, Task);
	topToBottom(30)(LittlePraktomat, Review, Solution);
	leftToRight(50)(Student, LittlePraktomat);


    drawObjects(Person, LittlePraktomat, Student, Review, Solution, Tutor, Task);


	link(inheritance)(pathStepX(Person.n, Student.s, 0));
	link(inheritance)(pathStepX(Person.s, Tutor.n, 0));

	link(aggregation)(pathStepX(Student.ne + (0, -15), Solution.nw + (0, -19), 20));
	link(aggregation)(pathStepX(Student.n, LittlePraktomat.nw + (0, -50), 0));
	link(aggregation)(pathStepX(Student.nw + (0, -15), Tutor.nw + (0, -33), -30));

	link(aggregation)(pathStepX(Tutor.nw + (0, -7), Student.nw + (0, -55), -15));
	link(aggregation)(pathStepX(Tutor.nw + (0, -7), LittlePraktomat.nw + (0, -39), -18));
	link(aggregation)(pathStepX(Tutor.nw + (0, -7), LittlePraktomat.nw + (0, -29), -21));

	link(aggregation)(pathStepX(Task.nw + (0, -7), LittlePraktomat.nw + (0, -60), -50));
	link(aggregation)(pathStepX(Task.ne + (0, -7), Solution.nw + (0, -30), 15));

	link(aggregation)(pathStepX(Solution.nw + (0, -7), LittlePraktomat.nw + (0, -82), -23));
	link(aggregation)(pathStepX(Solution.nw + (0, -7), Student.ne + (0, -7), -26));
	link(aggregation)(pathStepX(Solution.nw + (0, -7), Student.ne  + (0, -66), -29));
	link(aggregation)(pathStepX(Solution.nw + (0, -7), Tutor.ne  + (0, -45), -32));
	link(aggregation)(pathStepX(Solution.nw + (0, -59), Task.ne  + (0, -50), -20));
	link(aggregation)(pathStepX(Solution.ne + (0, -7), Review.ne + (0, -43), 15));

	link(aggregation)(pathStepX(Review.ne + (0, -7), Solution.ne + (0, -53), 30));
	link(aggregation)(pathStepX(Review.nw + (0, -7), Tutor.ne  + (0, -55), -10));

endfig;
end
