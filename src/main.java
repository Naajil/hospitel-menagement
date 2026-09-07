"""
Main menu: ties together PatientProfile/BST, WaitingLineManager (Queue),
TreatmentLog (Stack), and PatientHistoryChain (Linked List) into one
interactive hospital management program.
"""

from patient_profile import PatientProfile, PatientBST
from waiting_line_manager import WaitingLineManager
from treatment_log import TreatmentLog
from patient_history_chain import PatientHistoryChain

patient_bst = PatientBST()
waiting_line = WaitingLineManager()
treatment_log = TreatmentLog()
history_chains = {}  # patient_id -> PatientHistoryChain


def add_patient():
    pid = int(input("Patient ID: "))
    name = input("Name: ")
    age = int(input("Age: "))
    ailment = input("Ailment: ")
    profile = PatientProfile(pid, name, age, ailment)
    patient_bst.insert(profile)
    history_chains[pid] = PatientHistoryChain()
    waiting_line.enqueue(profile)
    print(f"Added and queued patient {pid}.")


def search_patient():
    pid = int(input("Patient ID to search: "))
    profile = patient_bst.search(pid)
    print(profile if profile else "Not found.")


def delete_patient():
    pid = int(input("Patient ID to delete: "))
    patient_bst.delete(pid)
    history_chains.pop(pid, None)
    print(f"Deleted patient {pid} (if existed).")


def serve_next_patient():
    profile = waiting_line.dequeue()
    if profile is None:
        print("Waiting line is empty.")
        return
    print(f"Now serving: {profile}")
    treatment = input("Enter treatment given: ")
    treatment_log.push((profile.patient_id, treatment))
    history_chains.setdefault(profile.patient_id, PatientHistoryChain())
    history_chains[profile.patient_id].add_entry(treatment)


def undo_last_treatment():
    record = treatment_log.pop()
    print(f"Undid: {record}" if record else "No treatments to undo.")


def show_patient_history():
    pid = int(input("Patient ID: "))
    chain = history_chains.get(pid)
    if not chain or chain.size() == 0:
        print("No history found.")
        return
    for i, entry in enumerate(chain.to_list(), 1):
        print(f"{i}. {entry}")


def list_all_patients():
    for profile in patient_bst.inorder():
        print(profile)


MENU = """
--- Hospital Management System ---
1. Add patient
2. Search patient
3. Delete patient
4. Show waiting line
5. Serve next patient
6. Undo last treatment
7. Show patient history
8. List all patients
0. Exit
"""


def main():
    while True:
        print(MENU)
        choice = input("Choose: ").strip()
        if choice == "1":
            add_patient()
        elif choice == "2":
            search_patient()
        elif choice == "3":
            delete_patient()
        elif choice == "4":
            for p in waiting_line.show_all():
                print(p)
        elif choice == "5":
            serve_next_patient()
        elif choice == "6":
            undo_last_treatment()
        elif choice == "7":
            show_patient_history()
        elif choice == "8":
            list_all_patients()
        elif choice == "0":
            print("Goodbye!")
            break
        else:
            print("Invalid choice.")


if __name__ == "__main__":
    main()
